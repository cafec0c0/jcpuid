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

import net.adambruce.jcpuid.type.CpuidResult;

/**
 * Interface for CPUID execution.
 */
public interface Cpuid {

    /**
     * Executes the CPUID instruction with the given leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    CpuidResult execute(int leaf);

    /**
     * Executes the CPUID instruction with the given leaf and sub-leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @param subleaf the sub-leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    CpuidResult execute(int leaf, int subleaf);
}
