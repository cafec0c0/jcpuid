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

package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.loader.NativeLibraryLoader;
import net.adambruce.jcpuid.loader.OperatingSystem;

/**
 * Provides utility methods for obtaining the CPUID instance for the current
 * platform.
 */
public final class CPUIDBridgeFactory {

    /** The loader that will be used for loading the native library. */
    private static final NativeLibraryLoader LOADER = new NativeLibraryLoader();

    /** Flag to prevent loading the native library more than once. */
    private static boolean hasLoadedPlatformLibrary = false;

    private CPUIDBridgeFactory() {

    }

    /**
     * Returns the correct bridge for the current platform.
     *
     * @return the CPUID bridge for the current platform
     * @throws InitialisationException no bridged were found for the platform
     */
    public static CPUIDBridge getPlatformBridge()
            throws InitialisationException {

        if (!hasLoadedPlatformLibrary) {
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().contains("linux")) {
                LOADER.loadLibraryForOperatingSystem(OperatingSystem.LINUX);
                hasLoadedPlatformLibrary = true;
            } else if (osName.toLowerCase().contains("windows")) {
                LOADER.loadLibraryForOperatingSystem(OperatingSystem.WINDOWS);
                hasLoadedPlatformLibrary = true;
            } else if (osName.toLowerCase().contains("mac os x")) {
                LOADER.loadLibraryForOperatingSystem(OperatingSystem.MACOS);
                hasLoadedPlatformLibrary = true;
            }
        }

        return new DefaultCPUIDBridge();
    }

}
