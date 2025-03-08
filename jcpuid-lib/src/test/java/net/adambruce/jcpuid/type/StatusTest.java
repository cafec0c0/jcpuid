package net.adambruce.jcpuid.type;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusTest {

    @ValueSource
    private static Stream<Arguments> getIntAndEnumValues() {
        return Stream.of(
                Arguments.of(-1, Status.UNKNOWN),
                Arguments.of(0, Status.FAILURE),
                Arguments.of(1, Status.SUCCESS)
        );
    }

    @ParameterizedTest
    @MethodSource("getIntAndEnumValues")
    public void testFromIntValue(int value, Status status) {
        assertEquals(status, Status.fromIntValue(value));
    }

    @ParameterizedTest
    @MethodSource("getIntAndEnumValues")
    public void testGetIntValue(int value, Status status) {
        assertEquals(value, status.getIntValue());
    }

}
