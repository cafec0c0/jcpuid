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
import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Register;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.type.Status;
import net.adambruce.jcpuid.util.RegisterUtils;
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
public class DefaultCPUIDTest {

    @Mock
    private CPUIDBridge bridge;

    @InjectMocks
    private DefaultCPUID cpuid;

    @Test
    public void testGetLargestStandardFunctionNumber() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(123);

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0000)).thenReturn(result);

        assertEquals(123, cpuid.getLargestStandardFunctionNumber());
    }

    @Test
    public void testGetProcessorVendor() throws Exception {
        Result result = mock(Result.class);
        Register ebx = RegisterUtils.stringRegister("Genu");
        Register ecx = RegisterUtils.stringRegister("ntel");
        Register edx = RegisterUtils.stringRegister("ineI");

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEbx()).thenReturn(ebx);
        when(result.getEcx()).thenReturn(ecx);
        when(result.getEdx()).thenReturn(edx);

        when(bridge.executeCPUID(0x0000_0000)).thenReturn(result);

        assertEquals("GenuineIntel", cpuid.getProcessorVendor());
    }

    @Test
    public void testGetProcessorFamily() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister((0x2 << 8) | (0x8 << 20));

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0x2, cpuid.getProcessorFamily());
    }

    @Test
    public void testGetProcessorFamilyWithExtendedFamily() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister((0xF << 8) | (0x8 << 20));

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0xF + 0x8, cpuid.getProcessorFamily());
    }

    @Test
    public void testGetProcessorStepping() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister(0x5);

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0x5, cpuid.getProcessorStepping());
    }

    @Test
    public void testGetProcessorModel() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister((0x3 << 4) | (0x9 << 16));

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0x3, cpuid.getProcessorModel());
    }

    @Test
    public void testGetProcessorModelWithExtendedModel() throws Exception {
        Result result = mock(Result.class);
        Register eax = RegisterUtils.intRegister((0xF << 4) | (0x9 << 16));

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEax()).thenReturn(eax);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals((0x9 << 4) | 0xF, cpuid.getProcessorModel());
    }

    @Test
    public void testGetLocalApicId() throws Exception {
        Result result = mock(Result.class);
        Register ebx = RegisterUtils.intRegister(0x23 << 24);

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEbx()).thenReturn(ebx);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0x23, cpuid.getLocalApicId());
    }

    @Test
    public void testGetCLFLUSHCacheLineSize() throws Exception {
        Result result = mock(Result.class);
        Register ebx = RegisterUtils.intRegister(0x13 << 8);

        when(result.getStatus()).thenReturn(Status.SUCCESS);
        when(result.getEbx()).thenReturn(ebx);

        when(bridge.executeCPUID(0x0000_0001)).thenReturn(result);

        assertEquals(0x13, cpuid.getCLFLUSHCacheLineSize());
    }

    @Test
    public void testExceptionThrownIfStatusIsNotSuccess() {
        Result result = mock(Result.class);
        when(result.getStatus()).thenReturn(Status.FAILURE);

        when(bridge.executeCPUID(0x0000_0000)).thenReturn(result);

        assertThrows(CPUIDException.class, () -> cpuid.getProcessorVendor());
    }
}
