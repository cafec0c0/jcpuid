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
import net.adambruce.jcpuid.exception.InitialisationException;

public class PrintAllCPUIDInformation {

    private final CPUID cpuid;

    public static void main(String[] args) throws InitialisationException {
        new PrintAllCPUIDInformation().run();
    }

    private PrintAllCPUIDInformation() throws InitialisationException {
        cpuid = CPUIDFactory.getPlatformCPUID();
    }

    private void run() {
        printLargestStandardFunctionNumber();
        printProcessorVendor();
    }

    private void printLargestStandardFunctionNumber() {
        try {
            int largestInstructionNum = cpuid.getLargestStandardFunctionNumber();
            System.out.println("Largest Standard Function Number: " + largestInstructionNum);
        } catch (CPUIDException ex) {
            printException("getLargestStandardFunctionNumber", ex);
        }
    }

    private void printProcessorVendor() {
        try {
            System.out.println("Vendor: " + cpuid.getProcessorVendor());
        } catch (CPUIDException ex) {
            printException("getProcessorVendor", ex);
        }
    }

    private static void printException(String func, Exception ex) {
        System.out.println("====== Error executing CPUID instruction ======");
        System.out.println("Function: " + func);
        System.out.println("Stack Trace:");
        ex.printStackTrace(System.err);
        System.out.println("===============================================");
    }
}
