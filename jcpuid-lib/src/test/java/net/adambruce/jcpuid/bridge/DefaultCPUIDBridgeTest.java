package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.exception.InitialisationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DefaultCPUIDBridgeTest {

    private static String osName;

    @BeforeAll
    public static void setup() {
        osName = System.getProperty("os.name");
    }

    @AfterEach
    public void resetOsName() {
        System.setProperty("os.name", osName);
    }

    @Test
    public void testConstructorThrowsExceptionWhenOSIsNotSupported() {
        System.setProperty("os.name", "temple os");
        assertThrows(InitialisationException.class, DefaultCPUIDBridge::new);
    }

}
