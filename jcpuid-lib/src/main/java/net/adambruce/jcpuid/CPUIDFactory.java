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
import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.exception.VendorNotSupportedException;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.vendor.amd.AmdCPUID;
import net.adambruce.jcpuid.vendor.intel.IntelCPUID;

public final class CPUIDFactory {

    private CPUIDFactory() {

    }

    /**
     * Gets the CPUID implementation for the current platform, loading the
     * native library if it has not already been loaded into the current JVM.
     *
     * @return the CPUID implementation for the current platform
     * @throws InitialisationException the platform CPUID implementation failed
     * @throws VendorNotSupportedException the processor vendor is not supported
     * to initialise.
     */
    public static CPUID getPlatformCPUID() throws InitialisationException,
            VendorNotSupportedException {
        CPUIDBridge bridge = CPUIDBridgeFactory.getPlatformBridge();
        Result result = bridge.executeCPUID(Leaf.LEAF_0H);
        String vendor = getVendorString(result);

        if (Vendors.INTEL.equals(vendor)) {
            return new IntelCPUID(bridge);
        }

        if (Vendors.AMD.equals(vendor)) {
            return new AmdCPUID(bridge);
        }

        throw new VendorNotSupportedException("The vendor " + vendor
                + " is not supported. To implement support for this processor "
                + "vendor, create a class implementing the CPUID interface.");

    }

    private static String getVendorString(final Result result) {
        return result.getEbx().getStringValue()
                + result.getEdx().getStringValue()
                + result.getEcx().getStringValue();
    }

}
