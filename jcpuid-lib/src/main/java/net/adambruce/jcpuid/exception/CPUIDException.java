package net.adambruce.jcpuid.exception;

/**
 * Exception for capturing failures in native CPUID instruction execution.
 */
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
