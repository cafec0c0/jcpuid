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

package net.adambruce.jcpuid.vendor.intel;

import net.adambruce.jcpuid.CPUID;
import net.adambruce.jcpuid.Leaf;
import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.vendor.intel.type.VersionInformation;

/**
 * CPUID implementation to expose Intel CPUID functions.
 */
public class IntelCPUID implements CPUID {

    /** The bridge used to execute native CPUID instructions. */
    private final CPUIDBridge bridgeImpl;

    /**
     * Create a new Intel CPUID instance using the provided bridge.
     *
     * @param bridge the bridge to use
     */
    public IntelCPUID(final CPUIDBridge bridge) {
        this.bridgeImpl = bridge;
    }

    /**
     * Obtains the largest standard function number supported by the processor.
     * EAX = 0h
     *
     * @return the largest standard function number
     */
    @Override
    public int getLargestStandardFunctionNumber() {
        Result result = getRawCPUID(Leaf.LEAF_0H);

        return result.getEax().getIntValue();
    }

    /**
     * Obtains the processor vendor string.
     * EAX = 0h
     *
     * @return the processor vendor string
     */
    @Override
    public String getProcessorVendor() {
        Result result = getRawCPUID(Leaf.LEAF_0H);

        return result.getEbx().getStringValue()
                + result.getEdx().getStringValue()
                + result.getEcx().getStringValue();
    }

    /**
     * Gets the processor version information.
     * This information is obtained using EAX=01h
     *
     * @return the version information
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public VersionInformation getVersionInformation() throws CPUIDException {
        return new VersionInformation(getRawCPUID(Leaf.LEAF_01H).getEax());
    }

    /**
     * Executes the CPUID instruction with the given leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    @Override
    public Result getRawCPUID(final int leaf) {
        return bridgeImpl.executeCPUID(leaf);
    }

    /**
     * Executes the CPUID instruction with the given leaf and sub-leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @param subleaf the sub-leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    @Override
    public Result getRawCPUID(final int leaf, final int subleaf) {
        return bridgeImpl.executeCPUID(leaf, subleaf);
    }
}
