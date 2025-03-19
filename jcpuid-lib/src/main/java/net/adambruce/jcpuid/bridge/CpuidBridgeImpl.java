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

import net.adambruce.jcpuid.type.CpuidResult;

/**
 * The default implementation of the CPUIDBridge interface.
 */
public class CpuidBridgeImpl implements CpuidBridge {

    /**
     * Executes the CPUID instruction using the given leaf.
     *
     * @param leaf the leaf
     * @return the result of the CPUID instruction execution
     */
    @Override
    public CpuidResult executeCPUID(final int leaf) {
        return executeCPUIDNative(leaf);
    }

    /**
     * Executes the CPUID instruction with the given leaf and sub-leaf nodes.
     *
     * @param leaf the leaf
     * @param subleaf the sub-leaf
     * @return the result containing register values and return value
     */
    @Override
    public CpuidResult executeCPUID(final int leaf, final int subleaf) {
        return executeCPUIDNative(leaf, subleaf);
    }

    private native CpuidResult executeCPUIDNative(int leaf);

    private native CpuidResult executeCPUIDNative(int leaf, int subleaf);
}
