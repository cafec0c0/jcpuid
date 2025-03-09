/*
 * Copyright 2025 Adam Bruce
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
