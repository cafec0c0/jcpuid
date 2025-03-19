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

public class CustomBridgeExample {

    public static void main(String[] args) {

        // Load the library for your bridge
        System.load("...");

        // Create our custom bridge implementation with native calls
        CustomBridge customBridge = new CustomBridge();

        // Get the platform CPUID using our bridge
        Cpuid cpuid = CpuidFactory.getPlatformCpuid(customBridge);

        // Use the JCPUID interfaces and implementations as normal
    }

}
