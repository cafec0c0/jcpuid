/*
 * Copyright 2025 Adam Bruce
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.adambruce.jcpuid.loader;

import net.adambruce.jcpuid.exception.CpuidException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
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
     * @param architecture the architecture to load the library for
     * @throws CpuidException the loader failed to load the library
     */
    public void loadLibrary(
            final OperatingSystem operatingSystem,
            final Architecture architecture)
            throws CpuidException {

        loadNativeLibrary(operatingSystem, architecture);
    }

    private String getLibraryPath(
            final OperatingSystem operatingSystem,
            final Architecture architecture)
            throws CpuidException {

        try (InputStream mappings = getClass().getClassLoader()
                .getResourceAsStream(MAPPING_PATH)) {

            Properties properties = new Properties();
            properties.load(mappings);

            String key = operatingSystem.getLookupName() + "_"
                    + architecture.getLookupName();

            return properties.getProperty(key);

        } catch (IOException ex) {
            throw new CpuidException("unable to load library "
                    + "mappings: " + ex);
        }
    }

    private void loadNativeLibrary(final OperatingSystem operatingSystem,
                                   final Architecture architecture)
            throws CpuidException {

        String path = getLibraryPath(operatingSystem, architecture);

        String[] parts = path.split("\\.");

        try {
            String fileSuffix = "." + parts[parts.length - 1];
            File out = File.createTempFile("jcpuid-native-", fileSuffix);

            InputStream libStream = getClass().getResourceAsStream(path);

            if (libStream == null) {
                throw new CpuidException("unable to locate the "
                        + "native library on the classpath");
            }

            Files.copy(libStream, out.getAbsoluteFile().toPath(),
                    StandardCopyOption.REPLACE_EXISTING);

            System.load(out.getAbsolutePath());
        } catch (IOException ex) {
            throw new CpuidException("unable to extract native "
                    + "library: " + ex);
        }
    }

}
