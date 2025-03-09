package net.adambruce.jcpuid.type;

import java.util.Objects;

/**
 * Holds the result of a CPUID instruction execution, including the status and
 * registers (EAX, EBX, ECX, EDX).
 */
public class Result {
    /** The status returned by the GCC <code>get_cpuid</code> wrapper. */
    private final Status status;

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
     * @param statusInt the status returned by the GCC's <code>get_cpuid</code>
     * @param eax the value returned in the EAX register
     * @param ebx the value returned in the EBX register
     * @param ecx the value returned in the ECX register
     * @param edx the value returned in the EDX register
     */
    public Result(final int statusInt, final int eax, final int ebx,
                  final int ecx, final int edx) {
        this.status = Status.fromIntValue(statusInt);
        this.eaxRegister = new Register(eax);
        this.ebxRegister = new Register(ebx);
        this.ecxRegister = new Register(ecx);
        this.edxRegister = new Register(edx);
    }

    /**
     * Get the status of the CPUID instruction execution.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
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
                + "status=" + status + ","
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

        return Objects.equals(this.status, other.status)
                && Objects.equals(this.eaxRegister, other.eaxRegister)
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
        return Objects.hash(status, eaxRegister, ebxRegister, ecxRegister,
                edxRegister);
    }
}
