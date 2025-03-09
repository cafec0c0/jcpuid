package net.adambruce.jcpuid.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InitialisationExceptionTest {

    @Test
    public void testInitialisationExceptionTest() {
        assertEquals("message", new InitialisationException("message").getMessage());
    }

}
