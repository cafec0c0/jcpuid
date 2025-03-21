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
 * Defines the required methods that a bridge must implement.
 */
public interface CpuidBridge {

    /**
     * Executes the CPUID instruction with the given leaf node.
     *
     * @param leaf the leaf
     * @return the result containing register values and return value
     */
    CpuidResult executeCPUID(int leaf);

    /**
     * Executes the CPUID instruction with the given leaf and sub-leaf nodes.
     *
     * @param leaf the leaf
     * @param subleaf the sub-leaf
     * @return the result containing register values and return value
     */
    CpuidResult executeCPUID(int leaf, int subleaf);
}
