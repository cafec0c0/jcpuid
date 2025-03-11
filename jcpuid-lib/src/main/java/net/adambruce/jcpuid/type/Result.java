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
 * Holds the result of a CPUID instruction execution the EAX, EBX, ECX and EDX
 * registers.
 */
public class Result {
    /** The value returned in the EAX register. */
    private final Register eaxRegister;

    /** The value returned in the EBX register. */
    private final Register ebxRegister;

    /** The value returned in the ECX register. */
    private final Register ecxRegister;

    /** The value returned in the EDX register. */
    private final Register edxRegister;

    /**
     * Create a new Result to store CPUID data.
     *
     * @param eax the value returned in the EAX register
     * @param ebx the value returned in the EBX register
     * @param ecx the value returned in the ECX register
     * @param edx the value returned in the EDX register
     */
    public Result(final int eax, final int ebx, final int ecx, final int edx) {
        this.eaxRegister = new Register(eax);
        this.ebxRegister = new Register(ebx);
        this.ecxRegister = new Register(ecx);
        this.edxRegister = new Register(edx);
    }

    /**
     * Get the value returned in the EAX register.
     *
     * @return the value returned in the EAX register
     */
    public Register getEax() {
        return eaxRegister;
    }

    /**
     * Get the value returned in the EBX register.
     *
     * @return the value returned in the EBX register
     */
    public Register getEbx() {
        return ebxRegister;
    }

    /**
     * Get the value returned in the ECX register.
     *
     * @return the value returned in the ECX register
     */
    public Register getEcx() {
        return ecxRegister;
    }

    /**
     * Get the value returned in the EDX register.
     *
     * @return the value returned in the EDX register
     */
    public Register getEdx() {
        return edxRegister;
    }

    /**
     * Returns the string representation of this result.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "CpuidResult{"
                + "eax=" + eaxRegister + ","
                + "ebx=" + ebxRegister + ","
                + "ecx=" + ecxRegister + ","
                + "edx=" + edxRegister
                + "}";
    }

    /**
     * Compares this result with the given result. The status and registers
     * will be compared.
     *
     * @param obj the other result
     * @return whether this result is equal to the other result
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Result)) {
            return false;
        }

        Result other = (Result) obj;

        return Objects.equals(this.eaxRegister, other.eaxRegister)
                && Objects.equals(this.ebxRegister, other.ebxRegister)
                && Objects.equals(this.ecxRegister, other.ecxRegister)
                && Objects.equals(this.edxRegister, other.edxRegister);
    }

    /**
     * Generates the hash code for this result using the status and registers.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(eaxRegister, ebxRegister, ecxRegister, edxRegister);
    }
}
