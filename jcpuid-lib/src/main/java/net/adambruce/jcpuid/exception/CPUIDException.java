package net.adambruce.jcpuid.exception;

public class CPUIDException extends Exception {

    /**
     * Create a new checked exception for CPUID instruction execution
     * exceptions.
     *
     * @param message the detail message
     */
    public CPUIDException(final String message) {
        super(message);
    }
}
