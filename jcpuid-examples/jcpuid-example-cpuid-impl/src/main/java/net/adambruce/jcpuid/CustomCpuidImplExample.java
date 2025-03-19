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

import net.adambruce.jcpuid.bridge.CpuidBridgeFactory;
import net.adambruce.jcpuid.exception.CpuidException;

public class CustomCpuidImplExample {

    public static void main(String[] args) throws CpuidException {
        // Create a new CPUID implementation wrapping a bridge
        CustomCpuidImpl cpuid = new CustomCpuidImpl(CpuidBridgeFactory.getPlatformBridge());

        // Use the custom CPUID functions
        System.out.println(cpuid.myCustomCPUIDFunctionForAVerySpecificProcessor());
    }

}
