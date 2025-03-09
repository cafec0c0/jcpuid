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

import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Result;

/**
 * Interface for native CPUID instructions.
 */
public interface CPUID {

    /**
     * Obtains the largest standard function number supported by the processor.
     *
     * @return the largest standard function number
     * @throws CPUIDException the native cpuid execution failed
     */
    int getLargestStandardFunctionNumber() throws CPUIDException;

    /**
     * Obtains the processor vendor string.
     *
     * @return the processor vendor string
     * @throws CPUIDException the native cpuid execution failed
     */
    String getProcessorVendor() throws CPUIDException;

    /**
     * Obtains the processor family.
     *
     * @return the processor family
     * @throws CPUIDException the native cpuid execution failed
     */
    int getProcessorFamily() throws CPUIDException;

    /**
     * Obtains the processor model.
     *
     * @return the processor model
     * @throws CPUIDException the native cpuid execution failed
     */
    int getProcessorModel() throws CPUIDException;

    /**
     * Obtains the processor stepping (revision number).
     *
     * @return the processor stepping
     * @throws CPUIDException the native cpuid execution failed
     */
    int getProcessorStepping() throws CPUIDException;

    /**
     * Obtains the local APIC ID.
     *
     * @return the local APIC ID
     * @throws CPUIDException the native cpuid execution failed
     */
    int getLocalApicId() throws CPUIDException;

    /**
     * Obtains the logical processor count.
     *
     * @return the logical processor count
     * @throws CPUIDException the native cpuid execution failed
     */
    int getLogicalProcessorCount() throws CPUIDException;

    /**
     * Obtains the size of a cache line in quadwords flushed by the CLFLUSH
     * instruction.
     *
     * @return the size of the cache line in quadwords
     * @throws CPUIDException the native cpuid execution failed
     */
    int getCLFLUSHCacheLineSize() throws CPUIDException;

    /**
     * Obtains the processor name string.
     *
     * @return the processor name string
     * @throws CPUIDException the native cpuid execution failed
     */
    String getProcessorNameString() throws CPUIDException;

    /**
     * Obtains the feature identifiers.
     *
     * @return the feature processor's feature availability
     * @throws CPUIDException the native cpuid execution failed
     */
    FeatureIdentifiers getFeatureIdentifiers() throws CPUIDException;

    /**
     * Executes the CPUID instruction with the given leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    Result getRawCPUID(int leaf);
}
