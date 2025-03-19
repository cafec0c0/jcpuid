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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CpuidResultTest {

    @Test
    public void testGetEax() {
        CpuidResult result = new CpuidResult(1, 0, 0, 0);
        assertEquals(new CpuidRegister(1), result.getEax());
    }

    @Test
    public void testGetEbx() {
        CpuidResult result = new CpuidResult(0, 1, 0, 0);
        assertEquals(new CpuidRegister(1), result.getEbx());
    }

    @Test
    public void testGetEcx() {
        CpuidResult result = new CpuidResult(0, 0, 1, 0);
        assertEquals(new CpuidRegister(1), result.getEcx());
    }

    @Test
    public void testGetEdx() {
        CpuidResult result = new CpuidResult(0, 0, 0, 1);
        assertEquals(new CpuidRegister(1), result.getEdx());
    }

    @Test
    public void testHashCode() {
        CpuidResult result1 = new CpuidResult(1, 2, 3, 4);
        CpuidResult result2 = new CpuidResult(1, 2, 3, 4);
        assertEquals(result1.hashCode(), result2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        CpuidResult result = new CpuidResult(1, 2, 3, 4);
        assertEquals(result, result);
    }

    @Test
    public void testEquals() {
        CpuidResult result1 = new CpuidResult(1, 2, 3, 4);
        CpuidResult result2 = new CpuidResult(1, 2, 3, 4);
        assertEquals(result1, result2);
    }

    @Test
    public void testNotEqual() {
        CpuidResult result1 = new CpuidResult(1, 2, 3, 4);
        CpuidResult result2 = new CpuidResult(2, 2, 3, 4);

        assertNotEquals(result1, result2);

        result2 = new CpuidResult(1, 3, 3, 4);
        assertNotEquals(result1, result2);

        result2 = new CpuidResult(1, 2, 4, 4);
        assertNotEquals(result1, result2);

        result2 = new CpuidResult(1, 2, 3, 5);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testNotEqualDifferentClass() {
        CpuidResult result = new CpuidResult(1, 2, 3, 4);
        String other = "other";
        assertNotEquals(result, other);
    }

    @Test
    public void testToString() {
        CpuidResult result = new CpuidResult(1, 2, 3, 4);
        String str = result.toString();
        assertTrue(str.contains("eax=" + new CpuidRegister(1)));
        assertTrue(str.contains("ebx=" + new CpuidRegister(2)));
        assertTrue(str.contains("ecx=" + new CpuidRegister(3)));
        assertTrue(str.contains("edx=" + new CpuidRegister(4)));
    }

}
