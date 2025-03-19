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

package net.adambruce.jcpuid.type;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {

    @Test
    public void testGetIntValue() {
        assertEquals(0x78000000, new Register(0x78000000).getIntValue());
    }

    @Test
    public void testGetShortValue() {
        assertEquals(0x7800, new Register(0x78000000).getShortValue(16));
    }

    @Test
    public void testGetByteValue() {
        assertEquals(0xEA, new Register(0xEA00).getByteValue(8));
    }

    @Test
    public void testGetNibbleValue() {
        assertEquals(0xF, new Register(0xF00).getNibbleValue(8));
    }

    @Test
    public void testGetBitValue() {
        assertEquals(1, new Register(0b10).getBitValue(1));
    }

    @Test
    public void testIsBitSet() {
        assertTrue(new Register(0b1000).isBitSet(3));
    }

    @Test
    public void testIsBitSetNotSet() {
        assertFalse(new Register(0b1000).isBitSet(2));
    }

    @Test
    public void testGetStringValue() {
        assertEquals("Test", new Register(0x74736554).getStringValue());
    }

    @Test
    public void testHashCode() {
        Register register1 = new Register(123);
        Register register2 = new Register(123);
        assertEquals(register1.hashCode(), register2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        Register register = new Register(4321);
        assertEquals(register, register);
    }

    @Test
    public void testEquals() {
        Register register1 = new Register(123);
        Register register2 = new Register(123);
        assertEquals(register1, register2);
    }

    @Test
    public void testNotEqual() {
        assertNotEquals(new Register(1), new Register(2));
    }

    @Test
    public void testNotEqualDifferentClass() {
        Register register = new Register(3452);
        String other = "other";
        assertNotEquals(register, other);
    }

    @Test
    public void testToString() {
        Register register = new Register(432);

        String str = register.toString();
        assertTrue(str.contains("value=0x" + Integer.toHexString(register.getIntValue())));
    }

}
