package net.adambruce.jcpuid.loader;

import net.adambruce.jcpuid.exception.InitialisationException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

/**
 * Utility for loading the native library for different platforms.
 */
public class NativeLibraryLoader {

    /** Path to the native library mappings. */
    private static final String MAPPING_PATH =
            "net/adambruce/jcpuid/lib-mappings.properties";

    /**
     * Loads the library for the specified operating system.
     *
     * @param operatingSystem the operating system to load the library for
     * @throws InitialisationException the loader failed to load the library
     */
    public void loadLibraryForOperatingSystem(
            final OperatingSystem operatingSystem)
            throws InitialisationException {

        loadNativeLibrary(operatingSystem);
    }

    private Path getLibraryPathForOperatingSystem(
            final OperatingSystem operatingSystem)
            throws InitialisationException {

        try (InputStream mappings = getClass().getClassLoader()
                .getResourceAsStream(MAPPING_PATH)) {

            Properties properties = new Properties();
            properties.load(mappings);

            return Paths.get(
                    properties.getProperty(operatingSystem.getLookupName()));

        } catch (IOException ex) {
            throw new InitialisationException("unable to load library "
                    + "mappings: " + ex);
        }
    }

    private void loadNativeLibrary(final OperatingSystem operatingSystem)
            throws InitialisationException {
        Path path = getLibraryPathForOperatingSystem(operatingSystem);
        String[] parts = path.getFileName().toString().split("\\.");

        try {
            String fileSuffix = "." + parts[parts.length - 1];
            File out = File.createTempFile("jcpuid-native-", fileSuffix);

            InputStream libStream = getClass()
                    .getResourceAsStream(path.toString());

            if (libStream == null) {
                throw new InitialisationException("unable to locate the "
                        + "native library on the classpath");
            }

            Files.copy(libStream, out.getAbsoluteFile().toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.load(out.getAbsolutePath());
        } catch (IOException ex) {
            throw new InitialisationException("unable to extract native "
                    + "library: " + ex);
        }
    }

}
