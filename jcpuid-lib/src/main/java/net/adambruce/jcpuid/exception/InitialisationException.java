package net.adambruce.jcpuid.exception;

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
