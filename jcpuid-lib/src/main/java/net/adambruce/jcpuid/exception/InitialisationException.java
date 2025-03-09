package net.adambruce.jcpuid.exception;

/**
 * Exception for capturing failures in the JCPUID library initialisation.
 */
public class InitialisationException extends Exception {

    /**
     * Create a new checked exception to capture exceptions that may get thrown
     * during library initialisation.
     *
     * @param message the detail message
     */
    public InitialisationException(final String message) {
        super(message);
    }
}
