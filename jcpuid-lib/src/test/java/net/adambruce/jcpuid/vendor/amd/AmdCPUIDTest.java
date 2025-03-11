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

package net.adambruce.jcpuid.vendor.amd;

import net.adambruce.jcpuid.Leaf;
import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.type.Register;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.util.RegisterUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AmdCPUIDTest {

    @Mock
    private CPUIDBridge bridge;

    @InjectMocks
    private AmdCPUID cpuid;

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
        Register ebx = RegisterUtils.stringRegister("Auth");
        Register ecx = RegisterUtils.stringRegister("cAMD");
        Register edx = RegisterUtils.stringRegister("enti");

        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(Leaf.LEAF_0H)).thenReturn(result);

        assertEquals("AuthenticAMD", cpuid.getProcessorVendor());
    }

}