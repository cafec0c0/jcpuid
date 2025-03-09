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

import java.util.Objects;

/**
 * Holds a register value and provides utility methods for accessing that data.
 */
public class Register {

    /** Width of a short in bits. */
    private static final int SHORT_WIDTH = 16;

    /** Width of a byte in bits. */
    private static final int BYTE_WIDTH = 8;

    /** Width of a nibble in bits. */
    private static final int NIBBLE_WIDTH = 4;

    /** Width of a bit in bits. */
    private static final int BIT_WIDTH = 1;

    /** Bit mask for shorts. */
    private static final int SHORT_MASK = 0xFFFF;

    /** Bit mask for bytes. */
    private static final int BYTE_MASK = 0xFF;

    /** Bit mask for nibbles. */
    private static final int NIBBLE_MASK = 0xF;

    /** The number of bytes (or characters) per register. */
    private static final int BYTES_PER_REGISTER = 4;


    /** The integer value of the register. */
    private final int intValue;

    /**
     * Create a new instance with the given register value.
     *
     * @param value the integer value of the register
     */
    public Register(final int value) {
        this.intValue = value;
    }

    /**
     * Gets the integer value of the register.
     *
     * @return the integer value
     */
    public int getIntValue() {
        return intValue;
    }

    /**
     * Gets the short value of the register at the given offset. Offsets are
     * the number of shorts to bit shift (not bits).
     *
     * @param shortOffset the offset (number of shorts)
     * @return the short value
     */
    public int getShortValue(final int shortOffset) {
        int shift = shortOffset * SHORT_WIDTH;
        return (intValue & (SHORT_MASK << shift)) >> shift;
    }

    /**
     * Gets the byte value of the register at the given offset. Offsets are
     * the number of bytes to bit shift (not bits).
     *
     * @param byteOffset the offset (number of bytes)
     * @return the byte value
     */
    public int getByteValue(final int byteOffset) {
        int shift = byteOffset * BYTE_WIDTH;
        return (intValue & (BYTE_MASK << shift)) >> shift;
    }

    /**
     * Gets the nibble value of the register at the given offset. Offsets are
     * the number of nibbles to bit shift (not bits).
     *
     * @param nibbleOffset the offset (number of nibbles)
     * @return the nibble value
     */
    public int getNibbleValue(final int nibbleOffset) {
        int shift = nibbleOffset * NIBBLE_WIDTH;
        return (intValue & (NIBBLE_MASK << shift)) >> shift;
    }

    /**
     * Gets the state of a bit in the register.
     *
     * @param bit the index of the bit to check
     * @return whether the bit is set
     */
    public boolean isBitSet(final int bit) {
        return (intValue & (BIT_WIDTH << bit)) != 0;
    }

    /**
     * Gets the contents of the register as a string.
     *
     * @return the string contained in the register
     */
    public String getStringValue() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BYTES_PER_REGISTER; i++) {
            int shift = i * BYTE_WIDTH;
            builder.append((char) ((intValue >> shift) & BYTE_MASK));
        }
        return builder.toString();
    }

    /**
     * Compares this register with the given register. The integer value of the
     * registers will be compared.
     *
     * @param obj the other register
     * @return whether this register is equal to the other register
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Register)) {
            return false;
        }

        Register other = (Register) obj;
        return this.intValue == other.intValue;
    }

    /**
     * Generates the hash code for this register using the integer value.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(intValue);
    }

    /**
     * Returns the string representation of this register.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "Register{value=" + intValue + "}";
    }
}
