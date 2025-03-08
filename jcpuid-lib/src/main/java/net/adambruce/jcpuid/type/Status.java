package net.adambruce.jcpuid.type;

public enum Status {

    /** The CPUID instruction executed successfully. */
    SUCCESS(1),

    /** The CPUID instruction executed exceptionally. */
    FAILURE(0),

    /** The CPUID instruction returned an unrecognised status. */
    UNKNOWN(-1);

    /** The integer value returned by GCC's <code>get_cpuid</code> wrapper. */
    private final int intValue;

    Status(final int value) {
        this.intValue = value;
    }

    /**
     * Returns the Status with the corresponding int value.
     *
     * @param value the int value returned from GCC's <code>get_cpuid</code>
     *              wrapper.
     * @return the matching status, otherwise UNKNOWN if the value does not
     * match any known statuses.
     */
    public static Status fromIntValue(final int value) {
        if (value == SUCCESS.getIntValue()) {
            return SUCCESS;
        }
        if (value == FAILURE.getIntValue()) {
            return FAILURE;
        }
        return UNKNOWN;
    }

    /**
     * Get the integer value returned by GCC's <code>get_cpuid</code> wrapper.
     *
     * @return the integer value of the status
     */
    public int getIntValue() {
        return intValue;
    }

}
