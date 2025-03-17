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
import net.adambruce.jcpuid.exception.VendorNotSupportedException;
import net.adambruce.jcpuid.vendor.amd.AmdCPUID;
import net.adambruce.jcpuid.vendor.intel.IntelCPUID;
import net.adambruce.jcpuid.vendor.intel.type.FeatureInformation;
import net.adambruce.jcpuid.vendor.intel.type.VersionInformation;

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
        System.out.printf("%-32s: %d%n", "Largest Standard Function Number", largestInstructionNum);
    }

    private static void printProcessorVendor(CPUID cpuid) {
        String vendor = cpuid.getProcessorVendor();
        System.out.printf("%-32s: %s%n", "Vendor", vendor);
    }

    private static class IntelCPUIDPrinter {
        public static void print(IntelCPUID cpuid) {
            printVersionInformation(cpuid);
            printBrandIndex(cpuid);
            printCLFLUSHLineSize(cpuid);
            printMaxNumberOfAddressableIds(cpuid);
            printInitialApicId(cpuid);
            printFeatureInformation(cpuid);
        }

        private static void printVersionInformation(IntelCPUID cpuid) {
            System.out.printf("%-32s%n", "Version Information");
            try {
                VersionInformation version = cpuid.getVersionInformation();
                System.out.printf("  %-30s: %d%n", "Stepping", version.getStepping());
                System.out.printf("  %-30s: %d%n", "Model", version.getModel());
                System.out.printf("  %-30s: %d%n", "Family", version.getFamily());
                System.out.printf("  %-30s: %s%n", "Type", version.getType());
                System.out.printf("  %-30s: %d%n", "Extended Model", version.getExtendedModel());
                System.out.printf("  %-30s: %d%n", "Extended Family", version.getExtendedFamily());
            } catch (CPUIDException ex) {
                System.out.println("  Exception: " + ex);
            }
        }

        private static void printBrandIndex(IntelCPUID cpuid) {
            System.out.printf("%-32s: ", "Brand String Index");
            try {
                System.out.println(cpuid.getBrandIndex());
            } catch (CPUIDException ex) {
                System.out.println("Exception: " + ex);
            }
        }

        private static void printCLFLUSHLineSize(IntelCPUID cpuid) {
            System.out.printf("%-32s: ", "CLFLUSH Line Size");
            try {
                int size = cpuid.getCLFLUSHLineSize();
                System.out.println(size + " (" + (size * 8) + " bytes)");
            } catch (CPUIDException ex) {
                System.out.println("Exception: " + ex);
            }
        }

        private static void printMaxNumberOfAddressableIds(IntelCPUID cpuid) {
            System.out.printf("%-32s: ", "Max Num of Addressable IDs");
            try {
                System.out.println(cpuid.getMaximumNumberOfAddressableIds());
            } catch (CPUIDException ex) {
                System.out.println("Exception: " + ex);
            }
        }

        private static void printInitialApicId(IntelCPUID cpuid) {
            System.out.printf("%-32s: ", "Initial APIC ID");
            try {
                System.out.println(cpuid.getInitialApicId());
            } catch (CPUIDException ex) {
                System.out.println("Exception: " + ex);
            }
        }

        private static void printFeatureInformation(IntelCPUID cpuid) {
            System.out.printf("%-32s: ", "Features");
            try {
                FeatureInformation info = cpuid.getFeatureInformation();
                StringBuilder builder = new StringBuilder();
                if (info.getSSE3()) builder.append("SSE3,");
                if (info.getPCLMULQDQ()) builder.append("PCLMULQDQ,");
                if (info.getDTES64()) builder.append("DTES64,");
                if (info.getDSCPL()) builder.append("DSCPL,");
                if (info.getVMX()) builder.append("VMX,");
                if (info.getSMX()) builder.append("SMX,");
                if (info.getEIST()) builder.append("EIST,");
                if (info.getTM2()) builder.append("TM2,");
                if (info.getSSSE3()) builder.append("SSSE3,");
                if (info.getCNXTID()) builder.append("CNXT-ID,");
                if (info.getSDBG()) builder.append("SDBG,");
                if (info.getFMA()) builder.append("FMA,");
                if (info.getCMPXCHG16B()) builder.append("CMPXCHG16B,");
                if (info.getXTPRUpdateControl()) builder.append("xTPR Update Control,");
                if (info.getPDCM()) builder.append("PDCM,");
                if (info.getPCID()) builder.append("PCID,");
                if (info.getDCA()) builder.append("DCA,");
                if (info.getSSE41()) builder.append("SSE4_1,");
                if (info.getSSE42()) builder.append("SSE4_2,");
                if (info.getX2APIC()) builder.append("x2APIC,");
                if (info.getMOVBE()) builder.append("MOVBE,");
                if (info.getPOPCNT()) builder.append("POPCNT,");
                if (info.getTSCDeadline()) builder.append("TSC-Deadline,");
                if (info.getAESNI()) builder.append("AESNI,");
                if (info.getXSAVE()) builder.append("XSAVE,");
                if (info.getOSXSAVE()) builder.append("OSXSAVE,");
                if (info.getAVX()) builder.append("AVX,");
                if (info.getF16C()) builder.append("F16C,");
                if (info.getRDRAND()) builder.append("RDRAND,");

                if (info.getFPU()) builder.append("FPU,");
                if (info.getVME()) builder.append("VME,");
                if (info.getDE()) builder.append("DE,");
                if (info.getPSE()) builder.append("PSE,");
                if (info.getTSC()) builder.append("TSC,");
                if (info.getMSR()) builder.append("MSR,");
                if (info.getPAE()) builder.append("PAE,");
                if (info.getMCE()) builder.append("MCE,");
                if (info.getCX8()) builder.append("CX8,");
                if (info.getAPIC()) builder.append("APIC,");
                if (info.getSEP()) builder.append("SEP,");
                if (info.getMTRR()) builder.append("MTRR,");
                if (info.getPGE()) builder.append("PGE,");
                if (info.getMCA()) builder.append("MCA,");
                if (info.getCMOV()) builder.append("CMOV,");
                if (info.getPAT()) builder.append("PAT,");
                if (info.getPSE36()) builder.append("PSE-36,");
                if (info.getPSN()) builder.append("PSN,");
                if (info.getCLFSH()) builder.append("CLFSH,");
                if (info.getDS()) builder.append("DS,");
                if (info.getACPI()) builder.append("ACPI,");
                if (info.getMMX()) builder.append("MMX,");
                if (info.getFXSR()) builder.append("FXSR,");
                if (info.getSSE()) builder.append("SSE,");
                if (info.getSSE2()) builder.append("SSE2,");
                if (info.getSS()) builder.append("SS,");
                if (info.getHTT()) builder.append("HTT,");
                if (info.getTM()) builder.append("TM,");
                if (info.getPBE()) builder.append("PBE,");

                if (builder.toString().endsWith(","))
                    System.out.println(builder.substring(0, builder.length() - 1));
                else
                    System.out.println(builder);
            } catch (CPUIDException ex) {
                System.out.println("Exception: " + ex);
            }
        }
    }

    private static class AmdCPUIDPrinter {
        public static void print(AmdCPUID cpuid) {

        }
    }
}
