package net.adambruce.jcpuid.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CPUIDExceptionTest {

    @Test
    public void testCPUIDException() {
        assertEquals("message", new CPUIDException("message").getMessage());
    }

}
