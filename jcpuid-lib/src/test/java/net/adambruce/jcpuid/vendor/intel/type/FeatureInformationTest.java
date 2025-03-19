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
import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FeatureInformationTest {

    private final static Register REGISTER =
            new Register(0b10101010101010101010101010101010);

    /* ECX */

    @Test
    void testGetSSE3() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getSSE3());
    }

    @Test
    void testGetPCLMULQDQ() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPCLMULQDQ());
    }

    @Test
    void testGetDTES64() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getDTES64());
    }

    @Test
    void testGetMONITOR() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getMONITOR());
    }

    @Test
    void testGetDSCPL() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getDSCPL());
    }

    @Test
    void testGetVMX() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getVMX());
    }

    @Test
    void testGetSMX() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getSMX());
    }

    @Test
    void testGetEIST() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getEIST());
    }

    @Test
    void testGetTM2() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getTM2());
    }

    @Test
    void testGetSSSE3() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSSSE3());
    }

    @Test
    void testGetCNXTID() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getCNXTID());
    }

    @Test
    void testGetSDBG() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSDBG());
    }

    @Test
    void testGetFMA() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getFMA());
    }

    @Test
    void testGetCMPXCHG16B() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getCMPXCHG16B());
    }

    @Test
    void testGetXTPRUpdateControl() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getXTPRUpdateControl());
    }

    @Test
    void testGetPDCM() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPDCM());
    }

    @Test
    void testGetPCID() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPCID());
    }

    @Test
    void testGetDCA() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getDCA());
    }

    @Test
    void testGetSSE41() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSSE41());
    }

    @Test
    void testSSE42() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getSSE42());
    }

    @Test
    void testGetX2APIC() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getX2APIC());
    }

    @Test
    void testGetMOVBE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getMOVBE());
    }

    @Test
    void testGetPOPCNT() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPOPCNT());
    }

    @Test
    void testGetTSCDeadline() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getTSCDeadline());
    }

    @Test
    void testGetAESNI() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getAESNI());
    }

    @Test
    void testGetXSAVE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getXSAVE());
    }

    @Test
    void testGetOSXSAVE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getOSXSAVE());
    }

    @Test
    void testGetAVX() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getAVX());
    }

    @Test
    void testGetF16C() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getF16C());
    }

    @Test
    void testGetRDRAND() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getRDRAND());
    }

    /* EDX */

    @Test
    void testGetFPU() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getFPU());
    }

    @Test
    void testGetVME() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getVME());
    }

    @Test
    void testGetDE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getDE());
    }

    @Test
    void testGetPSE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPSE());
    }

    @Test
    void testGetTSC() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getTSC());
    }

    @Test
    void testGetMSR() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getMSR());
    }

    @Test
    void testGetPAE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getPAE());
    }

    @Test
    void testGetMCE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getMCE());
    }

    @Test
    void testGetCX8() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getCX8());
    }

    @Test
    void testGetAPIC() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getAPIC());
    }

    @Test
    void testGetSEP() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSEP());
    }

    @Test
    void testGetMTRR() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getMTRR());
    }

    @Test
    void testGetPGE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPGE());
    }

    @Test
    void testGetMCA() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getMCA());
    }

    @Test
    void testGetCMOV() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getCMOV());
    }

    @Test
    void testGetPAT() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getPAT());
    }

    @Test
    void testGetPSE36() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPSE36());
    }

    @Test
    void testGetPSN() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getPSN());
    }

    @Test
    void testGetCLFSH() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getCLFSH());
    }

    @Test
    void testGetDS() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getDS());
    }

    @Test
    void testGetACPI() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getACPI());
    }

    @Test
    void testGetMMX() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getMMX());
    }

    @Test
    void testGetFXSR() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getFXSR());
    }

    @Test
    void testGetSSE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSSE());
    }

    @Test
    void testGetSSE2() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getSSE2());
    }

    @Test
    void testGetSS() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getSS());
    }

    @Test
    void testGetHTT() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertFalse(features.getHTT());
    }

    @Test
    void testGetTM() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getTM());
    }

    @Test
    void testGetPBE() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);

        assertTrue(features.getPBE());
    }

    @Test
    void testHashCode() {
        FeatureInformation features1 = new FeatureInformation(REGISTER, REGISTER);
        FeatureInformation features2 = new FeatureInformation(REGISTER, REGISTER);

        assertEquals(features1.hashCode(), features2.hashCode());
    }

    @Test
    void testEqualsSameObject() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);
        assertEquals(features, features);
    }

    @Test
    void testEquals() {
        FeatureInformation features1 = new FeatureInformation(REGISTER, REGISTER);
        FeatureInformation features2 = new FeatureInformation(REGISTER, REGISTER);

        assertEquals(features1, features2);
    }

    @Test
    void testNotEqual() {
        Register ecx1 = new Register(0b0);
        Register edx1 = new Register(0b0);
        FeatureInformation features1 = new FeatureInformation(ecx1, edx1);

        IntStream.range(0, 32)
                .filter(isNotReservedEcxRegister)
                .forEach(bit -> {
                    Register ecx2 = new Register(0b1 << bit);
                    FeatureInformation features2 = new FeatureInformation(ecx2, edx1);
                    assertNotEquals(features1, features2);
                });

        IntStream.range(0, 32)
                .filter(isNotReservedEdxRegister)
                .forEach(bit -> {
                    Register edx2 = new Register(0b1 << bit);
                    FeatureInformation features2 = new FeatureInformation(ecx1, edx2);
                    assertNotEquals(features1, features2);
                });
    }

    @Test
    void testNotEqualDifferentClass() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);
        String other = "other";
        assertNotEquals(features, other);
    }

    @Test
    void testToString() {
        FeatureInformation features = new FeatureInformation(REGISTER, REGISTER);
        String str = features.toString();

        /* ECX */
        assertTrue(str.contains("SSE3=false"));
        assertTrue(str.contains("PCLMULQDQ=true"));
        assertTrue(str.contains("DTES64=false"));
        assertTrue(str.contains("MONITOR=true"));
        assertTrue(str.contains("DS-CPL=false"));
        assertTrue(str.contains("VMX=true"));
        assertTrue(str.contains("SMX=false"));
        assertTrue(str.contains("EIST=true"));
        assertTrue(str.contains("TM2=false"));
        assertTrue(str.contains("SSSE3=true"));
        assertTrue(str.contains("CNXT-ID=false"));
        assertTrue(str.contains("SDBG=true"));
        assertTrue(str.contains("FMA=false"));
        assertTrue(str.contains("CMPXCHG16B=true"));
        assertTrue(str.contains("xTPR Update Control=false"));
        assertTrue(str.contains("PDCM=true"));
        assertTrue(str.contains("PCID=true"));
        assertTrue(str.contains("DCA=false"));
        assertTrue(str.contains("SSE4_1=true"));
        assertTrue(str.contains("SSE4_2=false"));
        assertTrue(str.contains("x2APIC=true"));
        assertTrue(str.contains("MOVBE=false"));
        assertTrue(str.contains("POPCNT=true"));
        assertTrue(str.contains("TSC-Deadline=false"));
        assertTrue(str.contains("AESNI=true"));
        assertTrue(str.contains("XSAVE=false"));
        assertTrue(str.contains("OSXSAVE=true"));
        assertTrue(str.contains("AVX=false"));
        assertTrue(str.contains("F16C=true"));
        assertTrue(str.contains("RDRAND=false"));

        /* EDX */
        assertTrue(str.contains("FPU=false"));
        assertTrue(str.contains("VME=true"));
        assertTrue(str.contains("DE=false"));
        assertTrue(str.contains("PSE=true"));
        assertTrue(str.contains("TSC=false"));
        assertTrue(str.contains("MSR=true"));
        assertTrue(str.contains("PAE=false"));
        assertTrue(str.contains("MCE=true"));
        assertTrue(str.contains("CX8=false"));
        assertTrue(str.contains("APIC=true"));
        assertTrue(str.contains("SEP=true"));
        assertTrue(str.contains("MTRR=false"));
        assertTrue(str.contains("PGE=true"));
        assertTrue(str.contains("MCA=false"));
        assertTrue(str.contains("CMOV=true"));
        assertTrue(str.contains("PAT=false"));
        assertTrue(str.contains("PSE-36=true"));
        assertTrue(str.contains("PSN=false"));
        assertTrue(str.contains("CLFSH=true"));
        assertTrue(str.contains("DS=true"));
        assertTrue(str.contains("ACPI=false"));
        assertTrue(str.contains("MMX=true"));
        assertTrue(str.contains("FXSR=false"));
        assertTrue(str.contains("SSE=true"));
        assertTrue(str.contains("SSE2=false"));
        assertTrue(str.contains("SS=true"));
        assertTrue(str.contains("HTT=false"));
        assertTrue(str.contains("TM=true"));
        assertTrue(str.contains("PBE=true"));
    }

    private static final IntPredicate isNotReservedEcxRegister = bit -> (bit != 16) && (bit != 31);
    private static final IntPredicate isNotReservedEdxRegister = bit -> (bit != 10) && (bit != 20) && (bit != 30);

}