package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.type.Result;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Properties;

public class DefaultCPUIDBridge implements CPUIDBridge {

    /** The path within this Jar to the native library mappings file. */
    private static final String MAPPING_PATH =
            "net/adambruce/jcpuid/lib-mappings.properties";

    /** Keep track the native library load state to prevent reloading. */
    private static boolean libLoaded = false;

    /**
     * Create a new default CPUID bridge instance.
     *
     * @throws InitialisationException the bridge did not initialise
     * successfully
     */
    public DefaultCPUIDBridge() throws InitialisationException {
        init();
    }

    private void init() throws InitialisationException {
        if (!libLoaded) {
            loadNativeLibrary();
        }
    }

    /**
     * Executes the CPUID instruction using the given leaf.
     *
     * @param leaf the leaf
     * @return the result of the CPUID instruction execution
     */
    @Override
    public Result executeCPUID(final int leaf) {
        return executeCPUIDNative(leaf);
    }

    private void loadNativeLibrary() throws InitialisationException {
        Path path = getLibraryPathForOperatingSystem();
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
            libLoaded = true;
        } catch (IOException ex) {
            throw new InitialisationException("unable to extract native "
                    + "library: " + ex);
        }
    }

    private Path getLibraryPathForOperatingSystem()
            throws InitialisationException {
        String osName = System.getProperty("os.name");
        String lookupKey = "";

        if (osName.toLowerCase().contains("windows")) {
            lookupKey = "windows";
        }

        if (osName.toLowerCase().contains("linux")) {
            lookupKey = "linux";
        }

        if (osName.toLowerCase().contains("mac os x")) {
            lookupKey = "macos";
        }

        try (InputStream mappings = getClass().getClassLoader()
                .getResourceAsStream(MAPPING_PATH)) {

            Properties properties = new Properties();
            properties.load(mappings);

            if (!properties.containsKey(lookupKey)) {
                throw new InitialisationException("this operating system is "
                        + "not supported");
            }

            return Paths.get(properties.getProperty(lookupKey));

        } catch (IOException ex) {
            throw new InitialisationException("unable to load library "
                    + "mappings: " + ex);
        }
    }

    private native Result executeCPUIDNative(int leaf);
}
