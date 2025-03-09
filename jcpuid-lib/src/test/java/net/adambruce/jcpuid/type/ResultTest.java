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

public class ResultTest {

    @Test
    public void testGetStatus() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 0, 0, 0, 0);
        assertEquals(Status.SUCCESS, result.getStatus());
    }

    @Test
    public void testGetEax() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 1, 0, 0, 0);
        assertEquals(new Register(1), result.getEax());
    }

    @Test
    public void testGetEbx() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 0, 1, 0, 0);
        assertEquals(new Register(1), result.getEbx());
    }

    @Test
    public void testGetEcx() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 0, 0, 1, 0);
        assertEquals(new Register(1), result.getEcx());
    }

    @Test
    public void testGetEdx() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 0, 0, 0, 1);
        assertEquals(new Register(1), result.getEdx());
    }

    @Test
    public void testHashCode() {
        Result result1 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        Result result2 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        assertEquals(result1.hashCode(), result2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        assertEquals(result, result);
    }

    @Test
    public void testEquals() {
        Result result1 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        Result result2 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        assertEquals(result1, result2);
    }

    @Test
    public void testNotEqual() {
        Result result1 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        Result result2 = new Result(Status.FAILURE.getIntValue(), 1, 2, 3, 4);
        assertNotEquals(result1, result2);

        result2 = new Result(Status.SUCCESS.getIntValue(), 2, 2, 3, 4);
        assertNotEquals(result1, result2);

        result2 = new Result(Status.SUCCESS.getIntValue(), 1, 3, 3, 4);
        assertNotEquals(result1, result2);

        result2 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 4, 4);
        assertNotEquals(result1, result2);

        result2 = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 5);
        assertNotEquals(result1, result2);
    }

    @Test
    public void testNotEqualDifferentClass() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        String other = "other";
        assertNotEquals(result, other);
    }

    @Test
    public void testToString() {
        Result result = new Result(Status.SUCCESS.getIntValue(), 1, 2, 3, 4);
        String str = result.toString();
        assertTrue(str.contains("status=SUCCESS"));
        assertTrue(str.contains("eax=Register{value=1}"));
        assertTrue(str.contains("ebx=Register{value=2}"));
        assertTrue(str.contains("ecx=Register{value=3}"));
        assertTrue(str.contains("edx=Register{value=4}"));
    }

}
