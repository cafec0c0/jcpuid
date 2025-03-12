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

package net.adambruce.jcpuid.vendor.intel;

import net.adambruce.jcpuid.Leaf;
import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Register;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.util.RegisterUtils;
import net.adambruce.jcpuid.vendor.intel.type.ProcessorType;
import net.adambruce.jcpuid.vendor.intel.type.VersionInformation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IntelCPUIDTest {

    @Mock
    private CPUIDBridge bridge;

    @InjectMocks
    private IntelCPUID cpuid;

    @Test
    public void testRawCPUID() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(111);
        Register ebx = RegisterUtils.intRegister(222);
        Register ecx = RegisterUtils.intRegister(333);
        Register edx = RegisterUtils.intRegister(444);

        when(result.getEax()).thenReturn(eax);
        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        Result rawResult = cpuid.getRawCPUID(Leaf.LEAF_0H);
        assertEquals(111, rawResult.getEax().getIntValue());
        assertEquals(222, rawResult.getEbx().getIntValue());
        assertEquals(333, rawResult.getEcx().getIntValue());
        assertEquals(444, rawResult.getEdx().getIntValue());
    }

    @Test
    public void testRawCPUIDWithSubleaf() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(111);
        Register ebx = RegisterUtils.intRegister(222);
        Register ecx = RegisterUtils.intRegister(333);
        Register edx = RegisterUtils.intRegister(444);

        when(result.getEax()).thenReturn(eax);
        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(Leaf.LEAF_0H, Leaf.LEAF_01H)).thenReturn(result);

        Result rawResult = cpuid.getRawCPUID(Leaf.LEAF_0H, Leaf.LEAF_01H);
        assertEquals(111, rawResult.getEax().getIntValue());
        assertEquals(222, rawResult.getEbx().getIntValue());
        assertEquals(333, rawResult.getEcx().getIntValue());
        assertEquals(444, rawResult.getEdx().getIntValue());
    }

    @Test
    public void testCheckedCPUID() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(111);
        Register ebx = RegisterUtils.intRegister(222);
        Register ecx = RegisterUtils.intRegister(333);
        Register edx = RegisterUtils.intRegister(444);

        when(result.getEax()).thenReturn(eax);
        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        Result rawResult = cpuid.getRawCPUID(Leaf.LEAF_0H);
        assertEquals(111, rawResult.getEax().getIntValue());
        assertEquals(222, rawResult.getEbx().getIntValue());
        assertEquals(333, rawResult.getEcx().getIntValue());
        assertEquals(444, rawResult.getEdx().getIntValue());
    }

    @Test
    public void testCheckedCPUIDWithException() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(0);

        when(result.getEax()).thenReturn(eax);

        // Mock max standard function call
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        assertThrows(CPUIDException.class, () ->  cpuid.getVersionInformation());
    }

    @Test
    public void testGetLargestStandardFunctionNumber() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(123);

        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        assertEquals(123, cpuid.getLargestStandardFunctionNumber());
    }

    @Test
    public void testGetProcessorVendor() {
        Result result = mock(Result.class);
        Register ebx = RegisterUtils.stringRegister("Genu");
        Register ecx = RegisterUtils.stringRegister("ntel");
        Register edx = RegisterUtils.stringRegister("ineI");

        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        assertEquals("GenuineIntel", cpuid.getProcessorVendor());
    }

    @Test
    public void testGetVersionInformation() throws CPUIDException {
        Result result = mock(Result.class);
        Register eax = new Register(0b00000000010110010000011011101010);

        when(result.getEax()).thenReturn(eax);

        Result largestStandardFunction = getLargestStandardFunctionResult();
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(largestStandardFunction);
        when(bridge.executeCPUID(Leaf.LEAF_01H)).thenReturn(result);

        VersionInformation version = cpuid.getVersionInformation();
        assertEquals(0b1010, version.getStepping());
        assertEquals(0b1110, version.getModel());
        assertEquals(0b0110, version.getFamily());
        assertEquals(ProcessorType.ORIGINAL_OEM_PROCESSOR, version.getType());
        assertEquals(0b1001, version.getExtendedModel());
        assertEquals(0b101, version.getExtendedFamily());
    }

    @Test
    void testGetBrandIndex() throws CPUIDException {
        Result result = mock(Result.class);
        Register ebx = new Register(0b00001000000100000000100000000010);

        when(result.getEbx()).thenReturn(ebx);

        Result largestStandardFunction = getLargestStandardFunctionResult();
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(largestStandardFunction);
        when(bridge.executeCPUID(Leaf.LEAF_01H)).thenReturn(result);

        assertEquals(0b10, cpuid.getBrandIndex());
    }

    @Test
    void testGetCLFLUSHLineSize() throws CPUIDException {
        Result result = mock(Result.class);
        Register ebx = new Register(0b00001000000100000000100000000000);

        when(result.getEbx()).thenReturn(ebx);

        Result largestStandardFunction = getLargestStandardFunctionResult();
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(largestStandardFunction);
        when(bridge.executeCPUID(Leaf.LEAF_01H)).thenReturn(result);

        assertEquals(0b1000, cpuid.getCLFLUSHLineSize());
    }

    @Test
    void testGetMaxNumberOfAddressableIds() throws CPUIDException {
        Result result = mock(Result.class);
        Register ebx = new Register(0b00001000001100000000100000000000);

        when(result.getEbx()).thenReturn(ebx);

        Result largestStandardFunction = getLargestStandardFunctionResult();
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(largestStandardFunction);
        when(bridge.executeCPUID(Leaf.LEAF_01H)).thenReturn(result);

        assertEquals(0b110000, cpuid.getMaximumNumberOfAddressableIds());
    }

    @Test
    void testGetInitialApicId() throws CPUIDException {
        Result result = mock(Result.class);
        Register ebx = new Register(0b00001001001100000000100000000000);

        when(result.getEbx()).thenReturn(ebx);

        Result largestStandardFunction = getLargestStandardFunctionResult();
        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(largestStandardFunction);
        when(bridge.executeCPUID(Leaf.LEAF_01H)).thenReturn(result);

        assertEquals(0b1001, cpuid.getInitialApicId());
    }

    private static Result getLargestStandardFunctionResult() {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(0xFFFFFFFF);
        when(result.getEax()).thenReturn(eax);
        return result;
    }

}