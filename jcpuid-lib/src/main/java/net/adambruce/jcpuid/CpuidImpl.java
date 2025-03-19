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
import net.adambruce.jcpuid.type.Result;

/**
 * Implementation of the CPUID interface.
 */
public class CpuidImpl implements Cpuid {

    /** The native bridge to use for executing CPUID instructions. */
    private final CPUIDBridge cpuidBridge;

    /**
     * Creates a new instance using the given bridge.
     *
     * @param bridge the bridge to use for executing CPUID instructions
     */
    public CpuidImpl(final CPUIDBridge bridge) {
        this.cpuidBridge = bridge;
    }

    /**
     * Executes the CPUID instruction with the given leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    @Override
    public Result execute(final int leaf) {
        return cpuidBridge.executeCPUID(leaf);
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
    public Result execute(final int leaf, final int subleaf) {
        return cpuidBridge.executeCPUID(leaf, subleaf);
    }
}
