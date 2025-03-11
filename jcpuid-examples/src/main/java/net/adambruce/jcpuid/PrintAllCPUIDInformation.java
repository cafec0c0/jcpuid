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

import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.exception.VendorNotSupportedException;
import net.adambruce.jcpuid.vendor.amd.AmdCPUID;
import net.adambruce.jcpuid.vendor.intel.IntelCPUID;

public class PrintAllCPUIDInformation {

    public static void main(String[] args) {
        try {
            CPUID cpuid = CPUIDFactory.getPlatformCPUID();
            printLargestStandardFunctionNumber(cpuid);
            printProcessorVendor(cpuid);

            if (cpuid instanceof IntelCPUID) {
                IntelCPUIDPrinter.print((IntelCPUID) cpuid);
            }

            if (cpuid instanceof AmdCPUID) {
                AmdCPUIDPrinter.print((AmdCPUID) cpuid);
            }

        } catch (InitialisationException ex) {
            System.err.println("Error initialising the CPUID library for the current platform: " + ex);
        } catch (VendorNotSupportedException ex) {
            System.err.println("The system's processor vendor is not supported: " + ex);
        }
    }

    private static void printLargestStandardFunctionNumber(CPUID cpuid) {
        int largestInstructionNum = cpuid.getLargestStandardFunctionNumber();
        System.out.println("Largest Standard Function Number: " + largestInstructionNum);
    }

    private static void printProcessorVendor(CPUID cpuid) {
        String vendor = cpuid.getProcessorVendor();
        System.out.println("Vendor: " + vendor);
    }

    private static class IntelCPUIDPrinter {
        public static void print(IntelCPUID cpuid) {

        }
    }

    private static class AmdCPUIDPrinter {
        public static void print(AmdCPUID cpuid) {

        }
    }
}
