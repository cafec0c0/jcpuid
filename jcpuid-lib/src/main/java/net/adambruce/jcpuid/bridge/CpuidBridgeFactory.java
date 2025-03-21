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

import net.adambruce.jcpuid.exception.CpuidException;
import net.adambruce.jcpuid.loader.Architecture;
import net.adambruce.jcpuid.loader.NativeLibraryLoader;
import net.adambruce.jcpuid.loader.OperatingSystem;

/**
 * Provides utility methods for obtaining the CPUID instance for the current
 * platform.
 */
public final class CpuidBridgeFactory {

    /** The loader that will be used for loading the native library. */
    private static final NativeLibraryLoader LOADER = new NativeLibraryLoader();

    /** Flag to prevent loading the native library more than once. */
    private static boolean hasLoadedPlatformLibrary = false;

    private CpuidBridgeFactory() {

    }

    /**
     * Returns the correct bridge for the current platform.
     *
     * @return the CPUID bridge for the current platform
     * @throws CpuidException no bridged were found for the platform
     */
    public static CpuidBridge getPlatformBridge()
            throws CpuidException {

        if (!hasLoadedPlatformLibrary) {
            LOADER.loadLibrary(getOperatingSystem(), getArchitecture());
            hasLoadedPlatformLibrary = true;
        }

        return new CpuidBridgeImpl();
    }

    private static Architecture getArchitecture()
            throws CpuidException {

        String osArch = System.getProperty("os.arch");
        if (osArch.equals("amd64")) {
            return Architecture.AMD64;
        }

        if (osArch.equals("x86")) {
            return Architecture.I386;
        }

        throw new CpuidException(
                "unsupported architecture: " + osArch);
    }

    private static OperatingSystem getOperatingSystem()
            throws CpuidException {

        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().contains("linux")) {
            return OperatingSystem.LINUX;
        }

        if (osName.toLowerCase().contains("windows")) {
            return OperatingSystem.WINDOWS;
        }

        if (osName.toLowerCase().contains("mac os x")) {
            return OperatingSystem.MACOS;
        }

        throw new CpuidException(
                "unsupported operating system: " + osName);
    }
}
