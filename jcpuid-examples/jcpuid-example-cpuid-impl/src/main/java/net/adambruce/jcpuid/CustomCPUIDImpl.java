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

public class CustomCPUIDImpl implements CPUID {

    private final CPUIDBridge bridge;

    public CustomCPUIDImpl(CPUIDBridge bridge) {
        this.bridge = bridge;
    }

    public int myCustomCPUIDFunctionForAVerySpecificProcessor() {
        return bridge.executeCPUID(0xDEADBEEF).getEdx().getIntValue();
    }

    @Override
    public int getLargestStandardFunctionNumber() {
        return bridge.executeCPUID(0x0).getEax().getIntValue();
    }

    @Override
    public String getProcessorVendor() {
        // You shouldn't really hardcode this, but this is just an example
        return "MyProcVendor";
    }

    @Override
    public Result getRawCPUID(int leaf) {
        return bridge.executeCPUID(leaf);
    }

    @Override
    public Result getRawCPUID(int leaf, int subleaf) {
        return bridge.executeCPUID(leaf, subleaf);
    }
}
