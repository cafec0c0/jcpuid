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

import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Register;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class VersionInformationTest {

    private static final int STEPPING_OFFSET = 0;
    private static final int MODEL_OFFSET = 4;
    private static final int FAMILY_OFFSET = 8;
    private static final int PROCESSOR_TYPE_OFFSET = 12;
    private static final int EXTENDED_MODEL_OFFSET = 16;
    private static final int EXTENDED_FAMILY_OFFSET = 20;

    @Test
    void testGetStepping() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(STEPPING_OFFSET)).thenReturn(0b1010);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b1010, version.getStepping());
    }

    @Test
    void testGetModel() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(MODEL_OFFSET)).thenReturn(0b1110);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b1110, version.getModel());
    }

    @Test
    void testGetFamily() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0b0110);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b0110, version.getFamily());
    }

    @Test
    void testGetType() throws CPUIDException{
        Register eax = mock(Register.class);

        when(eax.getBitValue(PROCESSOR_TYPE_OFFSET)).thenReturn(0b1);
        when(eax.getBitValue(PROCESSOR_TYPE_OFFSET + 1)).thenReturn(0b0);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(ProcessorType.INTEL_OVERDRIVE_PROCESSOR, version.getType());
    }

    @Test
    void testGetExtendedModel() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(EXTENDED_MODEL_OFFSET)).thenReturn(0b1001);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b1001, version.getExtendedModel());
    }

    @Test
    void testGetExtendedFamily() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getByteValue(EXTENDED_FAMILY_OFFSET)).thenReturn(0b00000101);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b00000101, version.getExtendedFamily());
    }

    @Test
    void testGetDisplayFamilyNotExtended() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0b101);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b101, version.getDisplayFamily());
    }

    @Test
    void testGetDisplayFamilyExtended() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0b1111);
        when(eax.getByteValue(EXTENDED_FAMILY_OFFSET)).thenReturn(0b1010);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b1111 + 0b1010, version.getDisplayFamily());
    }

    @Test
    void testGetDisplayModelNotExtended() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0b11);
        when(eax.getNibbleValue(MODEL_OFFSET)).thenReturn(0b1010);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b1010, version.getDisplayModel());
    }

    @Test
    void testGetDisplayModelExtendedFamilyIs06h() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0x6);
        when(eax.getNibbleValue(MODEL_OFFSET)).thenReturn(0b1010);
        when(eax.getNibbleValue(EXTENDED_MODEL_OFFSET)).thenReturn(0b1111);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b11111010, version.getDisplayModel());
    }

    @Test
    void testGetDisplayModelExtendedFamilyIs0Fh() throws CPUIDException {
        Register eax = mock(Register.class);

        when(eax.getNibbleValue(FAMILY_OFFSET)).thenReturn(0xf);
        when(eax.getNibbleValue(MODEL_OFFSET)).thenReturn(0b1010);
        when(eax.getNibbleValue(EXTENDED_MODEL_OFFSET)).thenReturn(0b1111);

        VersionInformation version = new VersionInformation(eax);
        assertEquals(0b11111010, version.getDisplayModel());
    }

    @Test
    void testEqualsSameObject() throws CPUIDException {
        Register register = new Register(0b00000000000010010000011011101010);
        VersionInformation version = new VersionInformation(register);

        assertEquals(version, version);
    }

    @Test
    void testNotEqualsDifferentClass() throws CPUIDException {
        Register register = new Register(0b00000000000010010000011011101010);
        VersionInformation version = new VersionInformation(register);

        assertNotEquals(version, "other");
    }

    @Test
    void testEquals() throws CPUIDException {
        Register register = new Register(0b00000000000010010000011011101010);
        VersionInformation version1 = new VersionInformation(register);

        VersionInformation version2 = new VersionInformation(register);
        assertEquals(version1, version2);
    }

    @Test
    void testNotEqual() throws CPUIDException {
        Register register1 = new Register(0b00000000000010010000011011101010);
        VersionInformation version1 = new VersionInformation(register1);

        Register register2 = new Register(0b00000000000010010000011011101011);
        VersionInformation version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);

        register2 = new Register(0b00000000000010010000011011111010);
        version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);

        register2 = new Register(0b00000000000010010000111011101010);
        version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);

        register2 = new Register(0b00000000000010010001011011101010);
        version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);

        register2 = new Register(0b00000000000010110000011011101010);
        version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);

        register2 = new Register(0b00000000000110010000011011101010);
        version2 = new VersionInformation(register2);
        assertNotEquals(version1, version2);
    }

    @Test
    void testHashCode() throws CPUIDException {
        Register register1 = new Register(0b00000000000010010000011011101010);
        VersionInformation version1 = new VersionInformation(register1);

        Register register2 = new Register(0b00000000000010010000011011101010);
        VersionInformation version2 = new VersionInformation(register2);

        assertEquals(version1.hashCode(), version2.hashCode());
    }

    @Test
    void testToString() throws CPUIDException {
        Register register1 = new Register(0b00000000000010010000011011101010);
        VersionInformation version = new VersionInformation(register1);

        String str = version.toString();
        assertTrue(str.contains("stepping=0xa"));
        assertTrue(str.contains("model=0xe"));
        assertTrue(str.contains("family=0x6"));
        assertTrue(str.contains("type=ORIGINAL_OEM_PROCESSOR"));
        assertTrue(str.contains("extendedModel=0x9"));
        assertTrue(str.contains("extendedFamily=0x0"));
    }

}