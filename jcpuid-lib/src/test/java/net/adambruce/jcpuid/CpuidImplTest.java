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

import net.adambruce.jcpuid.bridge.CpuidBridge;
import net.adambruce.jcpuid.type.CpuidRegister;
import net.adambruce.jcpuid.type.CpuidResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CpuidImplTest {

    @Mock
    private CpuidResult result;

    @Mock
    private CpuidBridge bridge;

    @InjectMocks
    private CpuidImpl cpuid;

    @Test
    void testExecute() {

        when(result.getEax()).thenReturn(new CpuidRegister(0xAAAAAAAA));
        when(result.getEbx()).thenReturn(new CpuidRegister(0xBBBBBBBB));
        when(result.getEcx()).thenReturn(new CpuidRegister(0xCCCCCCCC));
        when(result.getEdx()).thenReturn(new CpuidRegister(0xDDDDDDDD));
        when(bridge.executeCPUID(0x1)).thenReturn(result);

        CpuidResult actual = cpuid.execute(0x1);

        assertEquals(new CpuidRegister(0xAAAAAAAA), actual.getEax());
        assertEquals(new CpuidRegister(0xBBBBBBBB), actual.getEbx());
        assertEquals(new CpuidRegister(0xCCCCCCCC), actual.getEcx());
        assertEquals(new CpuidRegister(0xDDDDDDDD), actual.getEdx());
    }

    @Test
    void testExecuteWithSubleaf() {

        when(result.getEax()).thenReturn(new CpuidRegister(0xAAAAAAAA));
        when(result.getEbx()).thenReturn(new CpuidRegister(0xBBBBBBBB));
        when(result.getEcx()).thenReturn(new CpuidRegister(0xCCCCCCCC));
        when(result.getEdx()).thenReturn(new CpuidRegister(0xDDDDDDDD));
        when(bridge.executeCPUID(0x1, 0x2)).thenReturn(result);

        CpuidResult actual = cpuid.execute(0x1, 0x2);

        assertEquals(new CpuidRegister(0xAAAAAAAA), actual.getEax());
        assertEquals(new CpuidRegister(0xBBBBBBBB), actual.getEbx());
        assertEquals(new CpuidRegister(0xCCCCCCCC), actual.getEcx());
        assertEquals(new CpuidRegister(0xDDDDDDDD), actual.getEdx());
    }

}
