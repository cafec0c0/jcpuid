package net.adambruce.jcpuid;

import net.adambruce.jcpuid.exception.InitialisationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CPUIDTest {

    private static String systemArch;

    @BeforeAll
    public static void setup() {
        systemArch = System.getProperty("os.arch");
    }

    @AfterEach
    public void resetArch() {
        System.setProperty("os.arch", systemArch);
    }

    @Test
    public void testGetPlatformCPUIDThrowsWhenPlatformNotSupported() {
        System.setProperty("os.arch", "aarch64");
        assertThrows(InitialisationException.class, CPUID::getPlatformCPUID);
    }

}
