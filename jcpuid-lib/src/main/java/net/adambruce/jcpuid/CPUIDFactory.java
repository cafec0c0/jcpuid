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

import net.adambruce.jcpuid.bridge.CPUIDBridgeFactory;
import net.adambruce.jcpuid.exception.InitialisationException;

public final class CPUIDFactory {

    private CPUIDFactory() {

    }

    /**
     * Gets the CPUID implementation for the current platform, loading the
     * native library if it has not already been loaded into the current JVM.
     * The native library to be loaded will be determined based on the values
     * returned in the <code>os.arch</code> and <code>os.name</code> JVM
     * properties.
     *
     * @return the CPUID implementation for the current platform
     * @throws InitialisationException the platform CPUID implementation failed
     * to initialise.
     */
    static CPUID getPlatformCPUID() throws InitialisationException {
        if (System.getProperty("os.arch").equals("amd64")) {
            return new DefaultCPUID(CPUIDBridgeFactory.getPlatformBridge());
        }
        throw new InitialisationException("this platform is not supported");
    }

}
