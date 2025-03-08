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
        assertEquals(0x7800, new Register(0x78000000).getShortValue(1));
    }

    @Test
    public void testGetByteValue() {
        assertEquals(0xEA, new Register(0xEA00).getByteValue(1));
    }

    @Test
    public void testGetNibbleValue() {
        assertEquals(0xF, new Register(0xF00).getNibbleValue(2));
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
        assertNotEquals(other, register);
    }

    @Test
    public void testToString() {
        Register register = new Register(432);

        String str = register.toString();
        assertTrue(str.contains("value=" + register.getIntValue()));
    }

}
