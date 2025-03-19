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

package net.adambruce.jcpuid.vendor.intel.type;

import net.adambruce.jcpuid.type.Register;

import java.util.Objects;

/**
 * Stores the feature information of an Intel processor.
 */
public class FeatureInformation {

    /* === ECX === */

    /** Bit position of the SSE3 bit. */
    private static final int SSE3_OFFSET = 0;

    /** Bit position of the PCLMULQDQ bit. */
    private static final int PCLMULQDQ_OFFSET = 1;

    /** Bit position of the DTES64 bit. */
    private static final int DTES64_OFFSET = 2;

    /** Bit position of the MONITOR bit. */
    private static final int MONITOR_OFFSET = 3;

    /** Bit position of the DS-CPL bit. */
    private static final int DS_CPL_OFFSET = 4;

    /** Bit position of the VMX bit. */
    private static final int VMX_OFFSET = 5;

    /** Bit position of the SMX bit. */
    private static final int SMX_OFFSET = 6;

    /** Bit position of the EIST bit. */
    private static final int EIST_OFFSET = 7;

    /** Bit position of the TM2 bit. */
    private static final int TM2_OFFSET = 8;

    /** Bit position of the SSSE3 bit. */
    private static final int SSSE3_OFFSET = 9;

    /** Bit position of the CNXT-IT bit. */
    private static final int CNXT_ID_OFFSET = 10;

    /** Bit position of the SDBG bit. */
    private static final int SDBG_OFFSET = 11;

    /** Bit position of the FMA bit. */
    private static final int FMA_OFFSET = 12;

    /** Bit position of the CMPXCHG16B bit. */
    private static final int CMPXCHG16B_OFFSET = 13;

    /** Bit position of the xTPR bit. */
    private static final int XTPR_OFFSET = 14;

    /** Bit position of the PDCM bit. */
    private static final int PDCM_OFFSET = 15;

    /** Bit position of the PCID bit. */
    private static final int PCID_OFFSET = 17;

    /** Bit position of the DCA bit. */
    private static final int DCA_OFFSET = 18;

    /** Bit position of the SSE4_1 bit. */
    private static final int SSE4_1_OFFSET = 19;

    /** Bit position of the SSE4_2 bit. */
    private static final int SSE4_2_OFFSET = 20;

    /** Bit position of the x2APIC bit. */
    private static final int X2APIC_OFFSET = 21;

    /** Bit position of the MOVBE bit. */
    private static final int MOVBE_OFFSET = 22;

    /** Bit position of the POPCNT bit. */
    private static final int POPCNT_OFFSET = 23;

    /** Bit position of the TSC-Deadline bit. */
    private static final int TSC_DEADLINE_OFFSET = 24;

    /** Bit position of the AESNI bit. */
    private static final int AESNI_OFFSET = 25;

    /** Bit position of the XSAVE bit. */
    private static final int XSAVE_OFFSET = 26;

    /** Bit position of the OSXSAVE bit. */
    private static final int OSXSAVE_OFFSET = 27;

    /** Bit position of the AVX bit. */
    private static final int AVX_OFFSET = 28;

    /** Bit position of the F16C bit. */
    private static final int F16C_OFFSET = 29;

    /** Bit position of the RDRAND bit. */
    private static final int RDRAND_OFFSET = 30;

    /* === EDX === */

    /** Bit position of the FPU bit. */
    private static final int FPU_OFFSET = 0;

    /** Bit position of the VME bit. */
    private static final int VME_OFFSET = 1;

    /** Bit position of the DE bit. */
    private static final int DE_OFFSET = 2;

    /** Bit position of the PSE bit. */
    private static final int PSE_OFFSET = 3;

    /** Bit position of the TSC bit. */
    private static final int TSC_OFFSET = 4;

    /** Bit position of the MSR bit. */
    private static final int MSR_OFFSET = 5;

    /** Bit position of the PAE bit. */
    private static final int PAE_OFFSET = 6;

    /** Bit position of the MCE bit. */
    private static final int MCE_OFFSET = 7;

    /** Bit position of the CX8 bit. */
    private static final int CX8_OFFSET = 8;

    /** Bit position of the APIC bit. */
    private static final int APIC_OFFSET = 9;

    /** Bit position of the SEP bit. */
    private static final int SEP_OFFSET = 11;

    /** Bit position of the MTRR bit. */
    private static final int MTRR_OFFSET = 12;

    /** Bit position of the PGE bit. */
    private static final int PGE_OFFSET = 13;

    /** Bit position of the MCA bit. */
    private static final int MCA_OFFSET = 14;

    /** Bit position of the CMOV bit. */
    private static final int CMOV_OFFSET = 15;

    /** Bit position of the PAT bit. */
    private static final int PAT_OFFSET = 16;

    /** Bit position of the PSE-36 bit. */
    private static final int PSE_36_OFFSET = 17;

    /** Bit position of the PSN bit. */
    private static final int PSN_OFFSET = 18;

    /** Bit position of the CLFSH bit. */
    private static final int CLFSH_OFFSET = 19;

    /** Bit position of the DS bit. */
    private static final int DS_OFFSET = 21;

    /** Bit position of the ACPI bit. */
    private static final int ACPI_OFFSET = 22;

    /** Bit position of the MMX bit. */
    private static final int MMX_OFFSET = 23;

    /** Bit position of the FXSR bit. */
    private static final int FXSR_OFFSET = 24;

    /** Bit position of the SSE bit. */
    private static final int SSE_OFFSET = 25;

    /** Bit position of the SSE2 bit. */
    private static final int SSE2_OFFSET = 26;

    /** Bit position of the SS bit. */
    private static final int SS_OFFSET = 27;

    /** Bit position of the HTT bit. */
    private static final int HTT_OFFSET = 28;

    /** Bit position of the TM bit. */
    private static final int TM_OFFSET = 29;

    /** Bit position of the PBE bit. */
    private static final int PBE_OFFSET = 31;

    /* ECX */

    /** Does the processor support SSE3. */
    private final boolean sse3;

    /** Does the processor support PCLMULQDQ. */
    private final boolean pclmulqdq;

    /** Does the processor support DTES64. */
    private final boolean dtes64;

    /** Does the processor support MONITOR. */
    private final boolean monitor;

    /** Does the processor support DS-CPL. */
    private final boolean dsCpl;

    /** Does the processor support VMX. */
    private final boolean vmx;

    /** Does the processor support SMX. */
    private final boolean smx;

    /** Does the processor support EIST. */
    private final boolean eist;

    /** Does the processor support TM2. */
    private final boolean tm2;

    /** Does the processor support SSSE3. */
    private final boolean ssse3;

    /** Does the processor support CNXT-ID. */
    private final boolean cnxtId;

    /** Does the processor support SDBG. */
    private final boolean sdbg;

    /** Does the processor support FMA. */
    private final boolean fma;

    /** Does the processor support CMPXCHG16B. */
    private final boolean cmpxchg16b;

    /** Does the processor support xTPR Update Control. */
    private final boolean xtpr;

    /** Does the processor support PDCM. */
    private final boolean pdcm;

    /** Does the processor support PCID. */
    private final boolean pcid;

    /** Does the processor support DCA. */
    private final boolean dca;

    /** Does the processor support SSE4.1. */
    private final boolean sse41;

    /** Does the processor support SSE4.2. */
    private final boolean sse42;

    /** Does the processor support x2APIC. */
    private final boolean x2apic;

    /** Does the processor support MOVBE. */
    private final boolean movbe;

    /** Does the processor support POPCNT. */
    private final boolean popcnt;

    /** Does the processor support TSC-Deadline. */
    private final boolean tscDeadline;

    /** Does the processor support AESNI. */
    private final boolean aesni;

    /** Does the processor support XSAVE. */
    private final boolean xsave;

    /** Does the processor support OSXSAVE. */
    private final boolean osxsave;

    /** Does the processor support AVX. */
    private final boolean avx;

    /** Does the processor support F16C. */
    private final boolean f16c;

    /** Does the processor support RDRAND. */
    private final boolean rdrand;

    /* EDX */

    /** Does the processor support FPU. */
    private final boolean fpu;

    /** Does the processor support VME. */
    private final boolean vme;

    /** Does the processor support DE. */
    private final boolean de;

    /** Does the processor support PSE. */
    private final boolean pse;

    /** Does the processor support TSC. */
    private final boolean tsc;

    /** Does the processor support MSR. */
    private final boolean msr;

    /** Does the processor support PAE. */
    private final boolean pae;

    /** Does the processor support MCE. */
    private final boolean mce;

    /** Does the processor support CX8. */
    private final boolean cx8;

    /** Does the processor support APIC. */
    private final boolean apic;

    /** Does the processor support SEP. */
    private final boolean sep;

    /** Does the processor support MTRR. */
    private final boolean mtrr;

    /** Does the processor support PGE. */
    private final boolean pge;

    /** Does the processor support MCA. */
    private final boolean mca;

    /** Does the processor support CMOV. */
    private final boolean cmov;

    /** Does the processor support PAT. */
    private final boolean pat;

    /** Does the processor support PSE-36. */
    private final boolean pse36;

    /** Does the processor support PSN. */
    private final boolean psn;

    /** Does the processor support CLFSH. */
    private final boolean clfsh;

    /** Does the processor support DS. */
    private final boolean ds;

    /** Does the processor support ACPI. */
    private final boolean acpi;

    /** Does the processor support MMX. */
    private final boolean mmx;

    /** Does the processor support FXSR. */
    private final boolean fxsr;

    /** Does the processor support SSE. */
    private final boolean sse;

    /** Does the processor support SSE2. */
    private final boolean sse2;

    /** Does the processor support SS. */
    private final boolean ss;

    /** Does the processor support HTT. */
    private final boolean htt;

    /** Does the processor support TM. */
    private final boolean tm;

    /** Does the processor support PBE. */
    private final boolean pbe;

    /**
     * Creates a feature information instance with the given registers.
     *
     * @param ecx the ECX register
     * @param edx the EDX register
     */
    public FeatureInformation(final Register ecx, final Register edx) {
        /* ECX */
        this.sse3 = ecx.isBitSet(SSE3_OFFSET);
        this.pclmulqdq = ecx.isBitSet(PCLMULQDQ_OFFSET);
        this.dtes64 = ecx.isBitSet(DTES64_OFFSET);
        this.monitor = ecx.isBitSet(MONITOR_OFFSET);
        this.dsCpl = ecx.isBitSet(DS_CPL_OFFSET);
        this.vmx = ecx.isBitSet(VMX_OFFSET);
        this.smx = ecx.isBitSet(SMX_OFFSET);
        this.eist = ecx.isBitSet(EIST_OFFSET);
        this.tm2 = ecx.isBitSet(TM2_OFFSET);
        this.ssse3 = ecx.isBitSet(SSSE3_OFFSET);
        this.cnxtId = ecx.isBitSet(CNXT_ID_OFFSET);
        this.sdbg = ecx.isBitSet(SDBG_OFFSET);
        this.fma = ecx.isBitSet(FMA_OFFSET);
        this.cmpxchg16b = ecx.isBitSet(CMPXCHG16B_OFFSET);
        this.xtpr = ecx.isBitSet(XTPR_OFFSET);
        this.pdcm = ecx.isBitSet(PDCM_OFFSET);
        this.pcid = ecx.isBitSet(PCID_OFFSET);
        this.dca = ecx.isBitSet(DCA_OFFSET);
        this.sse41 = ecx.isBitSet(SSE4_1_OFFSET);
        this.sse42 = ecx.isBitSet(SSE4_2_OFFSET);
        this.x2apic = ecx.isBitSet(X2APIC_OFFSET);
        this.movbe = ecx.isBitSet(MOVBE_OFFSET);
        this.popcnt = ecx.isBitSet(POPCNT_OFFSET);
        this.tscDeadline = ecx.isBitSet(TSC_DEADLINE_OFFSET);
        this.aesni = ecx.isBitSet(AESNI_OFFSET);
        this.xsave = ecx.isBitSet(XSAVE_OFFSET);
        this.osxsave = ecx.isBitSet(OSXSAVE_OFFSET);
        this.avx = ecx.isBitSet(AVX_OFFSET);
        this.f16c = ecx.isBitSet(F16C_OFFSET);
        this.rdrand = ecx.isBitSet(RDRAND_OFFSET);

        /* EDX */
        this.fpu = edx.isBitSet(FPU_OFFSET);
        this.vme = edx.isBitSet(VME_OFFSET);
        this.de = edx.isBitSet(DE_OFFSET);
        this.pse = edx.isBitSet(PSE_OFFSET);
        this.tsc = edx.isBitSet(TSC_OFFSET);
        this.msr = edx.isBitSet(MSR_OFFSET);
        this.pae = edx.isBitSet(PAE_OFFSET);
        this.mce = edx.isBitSet(MCE_OFFSET);
        this.cx8 = edx.isBitSet(CX8_OFFSET);
        this.apic = edx.isBitSet(APIC_OFFSET);
        this.sep = edx.isBitSet(SEP_OFFSET);
        this.mtrr = edx.isBitSet(MTRR_OFFSET);
        this.pge = edx.isBitSet(PGE_OFFSET);
        this.mca = edx.isBitSet(MCA_OFFSET);
        this.cmov = edx.isBitSet(CMOV_OFFSET);
        this.pat = edx.isBitSet(PAT_OFFSET);
        this.pse36 = edx.isBitSet(PSE_36_OFFSET);
        this.psn = edx.isBitSet(PSN_OFFSET);
        this.clfsh = edx.isBitSet(CLFSH_OFFSET);
        this.ds = edx.isBitSet(DS_OFFSET);
        this.acpi = edx.isBitSet(ACPI_OFFSET);
        this.mmx = edx.isBitSet(MMX_OFFSET);
        this.fxsr = edx.isBitSet(FXSR_OFFSET);
        this.sse = edx.isBitSet(SSE_OFFSET);
        this.sse2 = edx.isBitSet(SSE2_OFFSET);
        this.ss = edx.isBitSet(SS_OFFSET);
        this.htt = edx.isBitSet(HTT_OFFSET);
        this.tm = edx.isBitSet(TM_OFFSET);
        this.pbe = edx.isBitSet(PBE_OFFSET);

    }

    /* ECX */

    /**
     * <strong>Streaming SIMD Extensions 3 (SSE3).</strong>
     * A value of 1 indicates the processor supports this technology.
     *
     * @return true if the processor supports streaming SIMD extenions 3,
     * otherwise false
     */
    public boolean getSSE3() {
        return sse3;
    }

    /**
     * <strong>PCLMULQDQ.</strong>
     * A value of 1 indicates the processor supports the PCLMULQDQ instruction.
     *
     * @return true if the processor supports the PCLMULQDQ instruction,
     * otherwise false
     */
    public boolean getPCLMULQDQ() {
        return pclmulqdq;
    }

    /**
     * <strong>64-bit DS Area.</strong>
     * A value of 1 indicates the processor supports DS area using 64-bit
     * layout.
     *
     * @return true if the processor supports DS area using 64-but layout,
     * otherwise false
     */
    public boolean getDTES64() {
        return dtes64;
    }

    /**
     * <strong>MONITOR/MWAIT.</strong>
     * A value of 1 indicates the processor supports this feature.
     *
     * @return true if the processor supports MONITOR/MWAIT, otherwise false
     */
    public boolean getMONITOR() {
        return monitor;
    }

    /**
     * <strong>CPL Qualified Debug Store.</strong>
     * A value of 1 indicates the processor supports the extensions to the
     * Debug Store feature to allow for branch message storage qualified by CPL.
     *
     * @return true if the processor supports the CPL debug store feature,
     * otherwise false
     */
    public boolean getDSCPL() {
        return dsCpl;
    }

    /**
     * <strong>Virtual Machine Extensions.</strong>
     * A value of 1 indicates that the processor supports this technology.
     *
     * @return true if the processor supports virtual machine extensions,
     * otherwise false
     */
    public boolean getVMX() {
        return vmx;
    }

    /**
     * <strong>Safer Mode Extensions.</strong>
     * A value of 1 indicates that the processor supports this technology. See
     * Chapter 7, "Safer Mode Extensions Reference."
     *
     * @return true if the processor supports safer mode extensions, otherwise
     * false
     */
    public boolean getSMX() {
        return smx;
    }

    /**
     * <strong>Enhanced Intel SpeedStep® technology.</strong>
     * A value of 1 indicates that the processor supports this technology.
     *
     * @return true if the processor supports enhanced Intel SpeedStep®
     * technology, otherwise false.
     */
    public boolean getEIST() {
        return eist;
    }

    /**
     * <strong>Thermal Monitor 2.</strong>
     * A value of 1 indicates whether the processor supports this technology.
     *
     * @return true if the processor supports the Thermal Monitor 2, otherwise
     * false
     */
    public boolean getTM2() {
        return tm2;
    }

    /**
     * <strong>Supplemental Streaming SIMD Extensions 3.</strong>
     * A value of 1 indicates the presence of the Supplemental Streaming SIMD
     * Extensions 3 (SSSE3). A value of 0 indicates the instruction extensions
     * are not present in the processor.
     *
     * @return true if the processor supports Supplemental Streaming SIMD
     * Extensions 3, otherwise false
     */
    public boolean getSSSE3() {
        return ssse3;
    }

    /**
     * <strong>L1 Context ID.</strong>
     * A value of 1 indicates the L1 data cache mode can be set to either
     * adaptive mode or shared mode. A value of 0 indicates this feature is not
     * supported. See definition of the IA32_MISC_ENABLE MSR Bit 24 (L1 Data
     * Cache Context Mode) for details.
     *
     * @return true if the processor allows the L1 cache model to be set to
     * adaptive mode or shared mode, otherwise false
     */
    public boolean getCNXTID() {
        return cnxtId;
    }

    /**
     * A value of 1 indicates the processor supports IA32_DEBUG_INTERFACE MSR
     * for silicon debug.
     *
     * @return true if the processor supports IA32_DEBUG_INTERFACE MSR for
     * silicon debug, otherwise false
     */
    public boolean getSDBG() {
        return sdbg;
    }

    /**
     * A value of 1 indicates the processor supports FMA extensions using YMM
     * state.
     *
     * @return true if the processor supports FMA extensions, otherwise false
     */
    public boolean getFMA() {
        return fma;
    }

    /**
     * <strong>CMPXCHG16B Available.</strong>
     * A value of 1 indicates that the feature is available. See the
     * "CMPXCHG8B/CMPXCHG16B—Compare and Exchange Bytes" section in this
     * chapter for a description.
     *
     * @return true if the CMPXCHG16B feature is available otherwise false
     */
    public boolean getCMPXCHG16B() {
        return cmpxchg16b;
    }

    /**
     * <strong>xTPR Update Control.</strong>
     * A value of 1 indicates that the processor supports changing
     * IA32_MISC_ENABLE[bit 23].
     *
     * @return true if the processor supports changing IA32_MISC_ENABLE[bit 23],
     * otherwise false.
     */
    public boolean getXTPRUpdateControl() {
        return xtpr;
    }

    /**
     * <strong>Perfmon and Debug Capability.</strong>
     * A value of 1 indicates the processor supports the performance and debug
     * feature indication MSR IA32_PERF_CAPABILITIES.
     *
     * @return true if the processor supports the Performance and Debug feature
     * identification MSR IA32_PERF_CAPABILITIES capabilities, otherwise false
     */
    public boolean getPDCM() {
        return pdcm;
    }

    /**
     * <strong>Process-context identifiers.</strong>
     * A value of 1 indicates that the processor supports PCIDs and that
     * software may set CR4.PCIDE to 1.
     *
     * @return true if the processor supports PCIDs and allows software to set
     * CR4.PCIDE to 1, otherwise false
     */
    public boolean getPCID() {
        return pcid;
    }

    /**
     * A value of 1 indicates the processor supports the ability to prefetch
     * data from a memory mapped device.
     *
     * @return true if the processor supports the ability to prefetch data from
     * a memory mapped device, otherwise false
     */
    public boolean getDCA() {
        return dca;
    }

    /**
     * A value of 1 indicates that the processor supports SSE4.1.
     *
     * @return true if the processor supports SSE4.1, otherwise false
     */
    public boolean getSSE41() {
        return sse41;
    }

    /**
     * A value of 1 indicates that the processor supports SSE4.2.
     *
     * @return true if the processor supports SSE4.2, otherwise false
     */
    public boolean getSSE42() {
        return sse42;
    }

    /**
     * A value of 1 indicates that the processor supports x2APIC feature.
     *
     * @return true if the processor supports the x2APIC feature, otherwise
     * false
     */
    public boolean getX2APIC() {
        return x2apic;
    }

    /**
     * A value of 1 indicates that the processor supports MOVBE instruction.
     *
     * @return true if the processor supports the MOVBE instruction, otherwise
     * false
     */
    public boolean getMOVBE() {
        return movbe;
    }

    /**
     * A value of 1 indicates that the processor supports the POPCNT
     * instruction.
     *
     * @return true if the processor supports the POPCNT instruction, otherwise
     * false
     */
    public boolean getPOPCNT() {
        return popcnt;
    }

    /**
     * A value of 1 indicates that the processor's local APIC timer supports
     * one-shot operation using a TSC deadline value.
     *
     * @return true if the processor's local APIC timer supports one-shot
     * operation using a TSC deadline value, otherwise false
     */
    public boolean getTSCDeadline() {
        return tscDeadline;
    }

    /**
     * A value of 1 indicates that the processor supports the AESNI instruction
     * extensions.
     *
     * @return true if the processor supports EASNI instruction extensions,
     * otherwise false
     */
    public boolean getAESNI() {
        return aesni;
    }

    /**
     * A value of 1 indicates that the processor supports the XSAVE/XRSTOR
     * processor extended states feature, the XSETBV/XGETBV instructions, and
     * XCR0.
     *
     * @return true if the processor supports the XSAVE/XRSTOR processor
     * extended state feature, the XSETBV/XGETBV instructions, and XCR0,
     * otherwise false
     */
    public boolean getXSAVE() {
        return xsave;
    }

    /**
     * A value of 1 indicates that the OS has set CR4.OSXSAVE[bit 18] to enable
     * XSETBV/XGETBV instructions to access XCR0 and to support processor
     * extended state management using XSAVE/XRSTOR.
     *
     * @return true if the processor allows the operating system to set
     * CR4.OSXSAVE[bit 18] to enable XSETBV/XGETBV instructions to access XCR0
     * and to support processor extended state management using XSAVE/XRSTOR,
     * otherwise false
     */
    public boolean getOSXSAVE() {
        return osxsave;
    }

    /**
     * A value of 1 indicates the processor supports the AVX instruction
     * extensions.
     *
     * @return true if the processor supports AVX instruction extensions,
     * otherwise false
     */
    public boolean getAVX() {
        return avx;
    }

    /**
     * A value of 1 indicates that processor supports 16-bit floating-point
     * conversion instructions.
     *
     * @return true if the processor supports 16-bt floating-point conversion
     * instructions, otherwise false
     */
    public boolean getF16C() {
        return f16c;
    }

    /**
     * A value of 1 indicates that processor supports RDRAND instruction.
     *
     * @return true if the processor supports the RDRAND instruction, otherwise
     * false
     */
    public boolean getRDRAND() {
        return rdrand;
    }

    /* EDX */

    /**
     * <strong>Floating-Point Unit On-Chip.</strong>
     * The processor contains an x87 FPU.
     *
     * @return true if the processor constains an x87 FPU, otherwise false
     */
    public boolean getFPU() {
        return fpu;
    }

    /**
     * <strong>Virtual 8086 Mode Enhancements.</strong>
     * Virtual 8086 mode enhancements, including
     * CR4.VME for controlling the feature, CR4.PVI for protected mode virtual
     * interrupts, software interrupt indirection, expansion of the TSS with the
     * software indirection bitmap, and EFLAGS.VIF and EFLAGS.VIP flags.
     *
     * @return true if the processor supports virtual 8086 mode enhancements,
     * otherwise false
     */
    public boolean getVME() {
        return vme;
    }

    /**
     * <strong>Debugging Extensions.</strong>
     * Support for I/O breakpoints, including CR4.DE for controlling the
     * feature, and optional trapping of accesses to DR4 and DR5.
     *
     * @return true if the processor supports debugging extensions, otherwise
     * false
     */
    public boolean getDE() {
        return de;
    }

    /**
     * <strong>Page Size Extension.</strong>
     * Large pages of size 4 MByte are supported, including CR4.PSE for
     * controlling the feature, the defined dirty bit in PDE (Page Directory
     * Entries), optional reserved bit trapping in CR3, PDEs, and PTEs.
     *
     * @return true if the processor supports large page sizes, otherwise false
     */
    public boolean getPSE() {
        return pse;
    }

    /**
     * <strong>Time Stamp Counter.</strong>
     * The RDTSC instruction is supported, including CR4.TSD for controlling
     * privilege.
     *
     * @return true if the processor supports the time stamp counter, otherwise
     * false
     */
    public boolean getTSC() {
        return tsc;
    }

    /**
     * <strong>Model Specific Registers RDMSR and WRMSR Instructions.</strong>
     * The RDMSR and WRMSR instructions are supported. Some of the MSRs are
     * implementation dependent.
     *
     * @return true if the processor supports model specific registers RDMSR
     * and WRMSR instructions, otherwise false
     */
    public boolean getMSR() {
        return msr;
    }

    /**
     * <strong>Physical Address Extension.</strong>
     * Physical addresses greater than 32 bits are supported: extended page
     * table entry formats, an extra level in the page translation tables is
     * defined, 2-MByte pages are supported instead of 4 Mbyte pages if PAE bit
     * is 1.
     *
     * @return true if the processor supports physical address extension,
     * otherwise false
     */
    public boolean getPAE() {
        return pae;
    }

    /**
     * <strong>Machine Check Exception.</strong>
     * Exception 18 is defined for Machine Checks, including CR4.MCE for
     * controlling the feature. This feature does not define the model-specific
     * implementations of machine-check error logging, reporting, and processor
     * shutdowns. Machine Check exception handlers may have to depend on
     * processor version to do model specific processing of the exception, or
     * test for the presence of the Machine Check feature.
     *
     * @return true if the processor supports machine check exception, otherwise
     * false
     */
    public boolean getMCE() {
        return mce;
    }

    /**
     * <strong>CMPXCHG8B Instruction.</strong>
     * The compare-and-exchange 8 bytes (64 bits) instruction is supported
     * (implicitly locked and atomic).
     *
     * @return true if the processor supports the CMPXCHG8B instruction,
     * otherwise false
     */
    public boolean getCX8() {
        return cx8;
    }

    /**
     * <strong>APIC On-Chip.</strong>
     * The processor contains an Advanced Programmable Interrupt Controller
     * (APIC), responding to memory mapped commands in the physical address
     * range FFFE0000H to FFFE0FFFH (by default - some processors permit the
     * APIC to be relocated).
     *
     * @return true if the processor contains an APIC, otherwise false
     */
    public boolean getAPIC() {
        return apic;
    }

    /**
     * <strong>SYSENTER and SYSEXIT Instructions.</strong>
     * The SYSENTER and SYSEXIT and associated MSRs are supported.
     *
     * @return true if the processor supports SYSENTER and SYSEXIT instructions,
     * otherwise false
     */
    public boolean getSEP() {
        return sep;
    }

    /**
     * <strong>Memory Type Range Registers.</strong>
     * MTRRs are supported. The MTRRcap MSR contains feature bits that describe
     * what memory types are supported, how many variable MTRRs are supported,
     * and whether fixed MTRRs are supported.
     *
     * @return true if MTRRs are supported, otherwise false
     */
    public boolean getMTRR() {
        return mtrr;
    }

    /**
     * <strong>Page Global Bit.</strong>
     * The global bit is supported in paging-structure entries that map a page,
     * indicating TLB entries that are common to different processes and need
     * not be flushed. The CR4.PGE bit controls this feature.
     *
     * @return true if the global bit is supported, otherwise false
     */
    public boolean getPGE() {
        return pge;
    }

    /**
     * <strong>Machine Check Architecture.</strong>
     * A value of 1 indicates the Machine Check Architecture of reporting
     * machine errors is supported. The MCG_CAP MSR contains feature bits
     * describing how many banks of error reporting MSRs are supported.
     *
     * @return true if machine check architecture of reporing machine errors is
     * supported, otherwise false
     */
    public boolean getMCA() {
        return mca;
    }

    /**
     * <strong>Conditional Move Instructions.</strong>
     * The conditional move instruction CMOV is supported. In addition, if x87
     * FPU is present as indicated by the CPUID.FPU feature bit, then the FCOMI
     * and FCMOV instructions are supported.
     *
     * @return true if the conditional move instruction is supported, otherwise
     * false
     */
    public boolean getCMOV() {
        return cmov;
    }

    /**
     * <strong>Page Attribute Table.</strong>
     * Page Attribute Table is supported. This feature augments the Memory Type
     * Range Registers (MTRRs), allowing an operating system to specify
     * attributes of memory accessed through a linear address on a 4KB g
     * ranularity.
     *
     * @return true if the page attribute table is supported, otherwise false.
     */
    public boolean getPAT() {
        return pat;
    }

    /**
     * <strong>36-Bit Page Size Extension.</strong>
     * 4-MByte pages addressing physical memory beyond 4 GBytes are supported
     * with 32-bit paging. This feature indicates that upper bits of the
     * physical address of a 4-MByte page are encoded in bits 20:13 of the
     * page-directory entry. Such physical addresses are limited by MAXPHYADDR
     * and may be up to 40 bits in size.
     *
     * @return true if 4-MByte pages addressing physical memory beyond 4 GBytes
     * are supported with 32-bit paging
     */
    public boolean getPSE36() {
        return pse36;
    }

    /**
     * <strong>Processor Serial Number.</strong>
     * The processor supports the 96-bit processor identification number feature
     * and the feature is enabled.
     *
     * @return true if the processor supports the 96-bit processor
     * identification number feature and the feature is enabled, otherwise false
     */
    public boolean getPSN() {
        return psn;
    }

    /**
     * <strong>CLFLUSH Instruction.</strong>
     * CLFLUSH Instruction is supported.
     *
     * @return true if the CLFLUSH instruction is supported, otherwise false
     */
    public boolean getCLFSH() {
        return clfsh;
    }

    /**
     * <strong>Debug Store.</strong>
     * The processor supports the ability to write debug information into a
     * memory resident buffer. This feature is used by the branch trace store
     * (BTS) and processor event-based sampling (PEBS) facilities (see Chapter
     * 25, "Introduction to Virtual Machine Extensions," in the Intel® 64 and
     * IA-32 Architectures Software Developer’s Manual, Volume 3C).
     *
     * @return true if the processor supports the ability to write debug
     * information into a memory resident buffer, otherwise false
     */
    public boolean getDS() {
        return ds;
    }

    /**
     * <strong>
     *     Thermal Monitor and Software Controlled Clock Facilities.
     * </strong>
     * The processor implements internal MSRs that allow processor temperature
     * to be monitored and processor performance to be modulated in predefined
     * duty cycles under software control.
     *
     * @return true if the processor implements internal MSRs, otherwise false
     */
    public boolean getACPI() {
        return acpi;
    }

    /**
     * <strong>Intel MMX Technology.</strong>
     * The processor supports the Intel MMX technology.
     *
     * @return true if the processor supports Intel MMX technology, otherwise
     * false
     */
    public boolean getMMX() {
        return mmx;
    }

    /**
     * <strong>FXSAVE and FXRSTOR Instructions.</strong>
     * The FXSAVE and FXRSTOR instructions are supported for fast save and
     * restore of the floating-point context. Presence of this bit also
     * indicates that CR4.OSFXSR is available for an operating system to
     * indicate that it supports the FXSAVE and FXRSTOR instructions.
     *
     * @return true if FXSAVE and FXRSTOR instructions are supported, otherwise
     * false
     */
    public boolean getFXSR() {
        return fxsr;
    }

    /**
     * <strong>SSE.</strong>
     * The processor supports the SSE extensions.
     *
     * @return true if the processor supports SSE extensions, otherwise false
     */
    public boolean getSSE() {
        return sse;
    }

    /**
     * <strong>SSE2.</strong>
     * The processor supports the SSE2 extensions.
     *
     * @return true if the processor supports SSE2 extensions, otherwise false
     */
    public boolean getSSE2() {
        return sse2;
    }

    /**
     * <strong>Self Snoop.</strong>
     * The processor supports the management of conflicting memory types by
     * performing a snoop of its own cache structure for transactions issued to
     * the bus.
     *
     * @return true if the processor supports the management of conflicting
     * memory types by performing a snoop, otherwise false
     */
    public boolean getSS() {
        return ss;
    }

    /**
     * <strong>Max APIC IDs reserved field is Valid.</strong>
     * A value of 0 for HTT indicates there is only a single logical processor
     * in the package and software should assume only a single APIC ID is
     * reserved. A value of 1 for HTT indicates the value in CPUID.1.EBX[23:16]
     * (the Maximum number of addressable IDs for logical processors in this
     * package) is valid for the package.
     *
     * @return true of the value in CPUID.1.EBX[23:16] is valid for this
     * package, otherwise false
     */
    public boolean getHTT() {
        return htt;
    }

    /**
     * <strong>Thermal Monitor.</strong>
     * The processor implements the thermal monitor automatic thermal control
     * circuitry (TCC).
     *
     * @return true if the processor implements the thermal monitor automatic
     * thermal control circuity, otherwise false
     */
    public boolean getTM() {
        return tm;
    }

    /**
     * <strong>Pending Break Enable.</strong>
     * The processor supports the use of the FERR#/PBE# pin when the processor
     * is in the stop-clock state (STPCLK# is asserted) to signal the processor
     * that an interrupt is pending and that the processor should return to
     * normal operation to handle the interrupt.
     *
     * @return true if the processor supports the use of the FERR#/PBE# pin when
     * the processir is in the stop-clock state, otherwise false
     */
    public boolean getPBE() {
        return pbe;
    }

    /**
     * Compares this feature information with the given feature information.
     * All supported (non-reserved) features will be compared.
     *
     * @param obj the other feature information
     * @return whether this feature information is equal to the other feature
     * information
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof FeatureInformation)) {
            return false;
        }

        FeatureInformation that = (FeatureInformation) obj;
        return this.sse3 == that.sse3
                && this.pclmulqdq == that.pclmulqdq
                && this.dtes64 == that.dtes64
                && this.monitor == that.monitor
                && this.dsCpl == that.dsCpl
                && this.vmx == that.vmx
                && this.smx == that.smx
                && this.eist == that.eist
                && this.tm2 == that.tm2
                && this.ssse3 == that.ssse3
                && this.cnxtId == that.cnxtId
                && this.sdbg == that.sdbg
                && this.fma == that.fma
                && this.cmpxchg16b == that.cmpxchg16b
                && this.xtpr == that.xtpr
                && this.pdcm == that.pdcm
                && this.pcid == that.pcid
                && this.dca == that.dca
                && this.sse41 == that.sse41
                && this.sse42 == that.sse42
                && this.x2apic == that.x2apic
                && this.movbe == that.movbe
                && this.popcnt == that.popcnt
                && this.tscDeadline == that.tscDeadline
                && this.aesni == that.aesni
                && this.xsave == that.xsave
                && this.osxsave == that.osxsave
                && this.avx == that.avx
                && this.f16c == that.f16c
                && this.rdrand == that.rdrand
                && this.fpu == that.fpu
                && this.vme == that.vme
                && this.de == that.de
                && this.pse == that.pse
                && this.tsc == that.tsc
                && this.msr == that.msr
                && this.pae == that.pae
                && this.mce == that.mce
                && this.cx8 == that.cx8
                && this.apic == that.apic
                && this.sep == that.sep
                && this.mtrr == that.mtrr
                && this.pge == that.pge
                && this.mca == that.mca
                && this.cmov == that.cmov
                && this.pat == that.pat
                && this.pse36 == that.pse36
                && this.psn == that.psn
                && this.clfsh == that.clfsh
                && this.ds == that.ds
                && this.acpi == that.acpi
                && this.mmx == that.mmx
                && this.fxsr == that.fxsr
                && this.sse == that.sse
                && this.sse2 == that.sse2
                && this.ss == that.ss
                && this.htt == that.htt
                && this.tm == that.tm
                && this.pbe == that.pbe;
    }

    /**
     * Generates the hash code for this set of feature information using each
     * of the supported (non-reserved) features.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(sse3, pclmulqdq, dtes64, monitor, dsCpl, vmx, smx,
                eist, tm2, ssse3, cnxtId, sdbg, fma, cmpxchg16b, xtpr, pdcm,
                pcid, dca, sse41, sse42, x2apic, movbe, popcnt, tscDeadline,
                aesni, xsave, osxsave, avx, f16c, rdrand, fpu, vme, de, pse,
                tsc, msr, pae, mce, cx8, apic, sep, mtrr, pge, mca, cmov, pat,
                pse36, psn, clfsh, ds, acpi, mmx, fxsr, sse, sse2, ss, htt, tm,
                pbe);
    }

    /**
     * Returns the string representation of this set of feature information.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "FeatureInformation{"
                + "SSE3=" + sse3 + ","
                + "PCLMULQDQ=" + pclmulqdq + ","
                + "DTES64=" + dtes64 + ","
                + "MONITOR=" + monitor + ","
                + "DS-CPL=" + dsCpl + ","
                + "VMX=" + vmx + ","
                + "SMX=" + smx + ","
                + "EIST=" + eist + ","
                + "TM2=" + tm2 + ","
                + "SSSE3=" + ssse3 + ","
                + "CNXT-ID=" + cnxtId + ","
                + "SDBG=" + sdbg + ","
                + "FMA=" + fma + ","
                + "CMPXCHG16B=" + cmpxchg16b + ","
                + "xTPR Update Control=" + xtpr + ","
                + "PDCM=" + pdcm + ","
                + "PCID=" + pcid + ","
                + "DCA=" + dca + ","
                + "SSE4_1=" + sse41 + ","
                + "SSE4_2=" + sse42 + ","
                + "x2APIC=" + x2apic + ","
                + "MOVBE=" + movbe + ","
                + "POPCNT=" + popcnt + ","
                + "TSC-Deadline=" + tscDeadline + ","
                + "AESNI=" + aesni + ","
                + "XSAVE=" + xsave + ","
                + "OSXSAVE=" + osxsave + ","
                + "AVX=" + avx + ","
                + "F16C=" + f16c + ","
                + "RDRAND=" + rdrand + ","
                + "FPU=" + fpu + ","
                + "VME=" + vme + ","
                + "DE=" + de + ","
                + "PSE=" + pse + ","
                + "TSC=" + tsc + ","
                + "MSR=" + msr + ","
                + "PAE=" + pae + ","
                + "MCE=" + mce + ","
                + "CX8=" + cx8 + ","
                + "APIC=" + apic + ","
                + "SEP=" + sep + ","
                + "MTRR=" + mtrr + ","
                + "PGE=" + pge + ","
                + "MCA=" + mca + ","
                + "CMOV=" + cmov + ","
                + "PAT=" + pat + ","
                + "PSE-36=" + pse36 + ","
                + "PSN=" + psn + ","
                + "CLFSH=" + clfsh + ","
                + "DS=" + ds + ","
                + "ACPI=" + acpi + ","
                + "MMX=" + mmx + ","
                + "FXSR=" + fxsr + ","
                + "SSE=" + sse + ","
                + "SSE2=" + sse2 + ","
                + "SS=" + ss + ","
                + "HTT=" + htt + ","
                + "TM=" + tm + ","
                + "PBE=" + pbe
                + "}";
    }
}
