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

package net.adambruce.jcpuid.vendor.intel.type;

import net.adambruce.jcpuid.exception.CPUIDException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ProcessorTypeTest {

    @ValueSource
    private static Stream<Arguments> getEnumsAndEncodings() {
        return Stream.of(
                Arguments.of(ProcessorType.ORIGINAL_OEM_PROCESSOR, 0b00),
                Arguments.of(ProcessorType.INTEL_OVERDRIVE_PROCESSOR, 0b01),
                Arguments.of(ProcessorType.DUAL_PROCESSOR, 0b10),
                Arguments.of(ProcessorType.INTEL_RESERVED, 0b11)
        );
    }

    @ParameterizedTest
    @MethodSource("getEnumsAndEncodings")
    void testFrom(ProcessorType type, int encoding) throws CPUIDException {
        assertEquals(type, ProcessorType.from(encoding));
    }

    @Test
    void testFromException() {
        assertThrows(CPUIDException.class, () -> ProcessorType.from(0b100));
    }

    @Test
    void testGetEncoding() {
        assertEquals(ProcessorType.ORIGINAL_OEM_PROCESSOR.getEncoding(), 0b00);
    }

}