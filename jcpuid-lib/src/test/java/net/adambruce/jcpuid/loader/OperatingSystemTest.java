package net.adambruce.jcpuid.loader;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatingSystemTest {

    @ValueSource
    private static Stream<Arguments> getEnumsAndNames() {
        return Stream.of(
                Arguments.of(OperatingSystem.LINUX, "linux"),
                Arguments.of(OperatingSystem.WINDOWS, "windows"),
                Arguments.of(OperatingSystem.MACOS, "macos")
        );
    }

    @ParameterizedTest
    @MethodSource("getEnumsAndNames")
    public void testGetLookupName(OperatingSystem operatingSystem, String name) {
        assertEquals(name, operatingSystem.getLookupName());
    }

}
