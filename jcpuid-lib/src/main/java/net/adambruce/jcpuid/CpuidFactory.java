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

package net.adambruce.jcpuid;

import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.bridge.CPUIDBridgeFactory;
import net.adambruce.jcpuid.exception.CpuidException;

public final class CpuidFactory {

    private CpuidFactory() {

    }

    /**
     * Gets the CPUID implementation for the current platform, loading the
     * native library if it has not already been loaded into the current JVM.
     *
     * @return the CPUID implementation for the current platform
     * @throws CpuidException the platform CPUID implementation failed
     * to initialise.
     */
    public static Cpuid getPlatformCpuid() throws CpuidException {
        return getPlatformCpuid(CPUIDBridgeFactory.getPlatformBridge());
    }

    /**
     * Gets the CPUID implementation for the current platform, using the
     * provided bridge. This method will not load any native libraries.
     *
     * @param bridge the CPUID bridge to use
     * @return the CPUID implementation for the current platform
     * to initialise.
     */
    public static Cpuid getPlatformCpuid(final CPUIDBridge bridge) {
        return new CpuidImpl(bridge);
    }
}
