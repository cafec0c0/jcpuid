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
import net.adambruce.jcpuid.vendor.intel.type.FeatureInformation;
import net.adambruce.jcpuid.vendor.intel.type.VersionInformation;

/**
 * CPUID implementation to expose Intel CPUID functions.
 */
public class IntelCPUID implements CPUID {

    /** Offset for accessing the brand index from EBX when EAX=1. */
    private static final int BRAND_INDEX_OFFSET = 0;

    /** Offset for accessing the CLFLUSH size from EBX when EAX=1. */
    private static final int CLFLUSH_OFFSET = 8;

    /**
     * Offset for accessing the maximum number of addressable IDs from EBX
     * when EAX=1.
     */
    private static final int MAX_ADDRESSABLE_IDS_OFFSET = 16;

    /** Offset for accessing the initial APIC ID from EBX when EAX=1. */
    private static final int INITIAL_APIC_ID_OFFSET = 24;


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
     * This value is obtained from EAX when EAX=0h
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
     * This value is obtained from EBX,ECX,EDX when EAX=0h
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
     * This value is obtained from EAX when EAX=01h
     *
     * @return the version information
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public VersionInformation getVersionInformation() throws CPUIDException {
        return new VersionInformation(getCheckedCPUID(Leaf.LEAF_01H).getEax());
    }

    /**
     * Gets the index for the brand string table stored on the processor.
     * This value is obtained from EBX when EAX=01h
     *
     * @return the index of the brand string table
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public int getBrandIndex() throws CPUIDException {
        return getCheckedCPUID(Leaf.LEAF_01H).getEbx()
                .getByteValue(BRAND_INDEX_OFFSET);
    }

    /**
     * Gets the CLFLUSH line size for the processor
     * (value * 8 = line size in bytes).
     * This value is obtained from EBX when EAX=01h
     *
     * @return the CLFLUSH line size
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public int getCLFLUSHLineSize() throws CPUIDException {
        return getCheckedCPUID(Leaf.LEAF_01H).getEbx()
                .getByteValue(CLFLUSH_OFFSET);
    }

    /**
     * Gets the maximum number of addressable IDs for logical processors in this
     * physical package.
     *
     * @return the maximum number of addressable IDs.
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public int getMaximumNumberOfAddressableIds() throws CPUIDException {
        return getCheckedCPUID(Leaf.LEAF_01H).getEbx()
                .getByteValue(MAX_ADDRESSABLE_IDS_OFFSET);
    }

    /**
     * Gets the initial APIC ID. This is replaced by the 32-bit x2APIC ID.
     *
     * @return the initial APIC ID
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public int getInitialApicId() throws CPUIDException {
        return getCheckedCPUID(Leaf.LEAF_01H).getEbx()
                .getByteValue(INITIAL_APIC_ID_OFFSET);
    }

    /**
     * Gets the features supported by this processor.
     *
     * @return the features
     * @throws CPUIDException an exception occurred during the CPUID
     * instruction execution.
     */
    public FeatureInformation getFeatureInformation() throws CPUIDException {
        Result result = getCheckedCPUID(Leaf.LEAF_01H);
        return new FeatureInformation(result.getEcx(), result.getEdx());
    }

    private Result getCheckedCPUID(final int leaf) throws CPUIDException {
        int largestStandardFunctionNumber = getLargestStandardFunctionNumber();
        if (Integer.compareUnsigned(leaf, largestStandardFunctionNumber) > 0) {
            throw new CPUIDException("this function is not supported by this "
                    + "processor");
        }

        return getRawCPUID(leaf);
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
