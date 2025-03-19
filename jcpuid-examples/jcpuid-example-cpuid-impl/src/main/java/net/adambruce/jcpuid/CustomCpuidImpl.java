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

import net.adambruce.jcpuid.bridge.CpuidBridge;
import net.adambruce.jcpuid.type.CpuidResult;

public class CustomCpuidImpl implements Cpuid {

    private final CpuidBridge bridge;

    public CustomCpuidImpl(CpuidBridge bridge) {
        this.bridge = bridge;
    }

    public int myCustomCPUIDFunctionForAVerySpecificProcessor() {
        return bridge.executeCPUID(0xDEADBEEF).getEdx().getIntValue();
    }

    @Override
    public CpuidResult execute(int leaf) {
        return bridge.executeCPUID(leaf);
    }

    @Override
    public CpuidResult execute(int leaf, int subleaf) {
        return bridge.executeCPUID(leaf, subleaf);
    }
}
