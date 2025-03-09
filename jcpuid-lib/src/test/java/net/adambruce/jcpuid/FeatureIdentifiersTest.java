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

package net.adambruce.jcpuid;

import net.adambruce.jcpuid.type.Register;
import org.junit.jupiter.api.Test;

import static net.adambruce.jcpuid.FeatureIdentifiers.fromRegister;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FeatureIdentifiersTest {

    @Test
    public void testHashCode() {
        FeatureIdentifiers features1 = fromRegister(new Register(123));
        FeatureIdentifiers features2 = fromRegister(new Register(123));
        assertEquals(features1.hashCode(), features2.hashCode());
    }

    @Test
    public void testEqualsSameObject() {
        FeatureIdentifiers features = fromRegister(new Register(123));
        assertEquals(features, features);
    }

    @Test
    public void testEquals() {
        FeatureIdentifiers features1 = fromRegister(new Register(123));
        FeatureIdentifiers features2 = fromRegister(new Register(123));
        assertEquals(features1, features2);
    }

    @Test
    public void testNotEqualDifferentClass() {
        FeatureIdentifiers features = fromRegister(new Register(123));
        String other = "other";
        assertNotEquals(other, features);
    }

    @Test
    public void testNotEqual() {
        assertNotEquals(fromRegister(new Register(1 << 31)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 29)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 28)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 27)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 26)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 25)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 23)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 20)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 19)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 13)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 12)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 9)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 3)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1 << 1)),  fromRegister(new Register(0)));
        assertNotEquals(fromRegister(new Register(1)),  fromRegister(new Register(0)));
    }

    @Test
    public void testToString() {
        FeatureIdentifiers features = fromRegister(new Register(0xFFFFFFFF));

        String str = features.toString();
        assertTrue(str.contains("RAZ=true"));
        assertTrue(str.contains("F16C=true"));
        assertTrue(str.contains("AVX=true"));
        assertTrue(str.contains("OSXSAVE=true"));
        assertTrue(str.contains("XSAVE=true"));
        assertTrue(str.contains("AES=true"));
        assertTrue(str.contains("POPCNT=true"));
        assertTrue(str.contains("SSE4.2=true"));
        assertTrue(str.contains("SSE4.1=true"));
        assertTrue(str.contains("CMPXCHG16B=true"));
        assertTrue(str.contains("FMA=true"));
        assertTrue(str.contains("SSSE3=true"));
        assertTrue(str.contains("MONITOR=true"));
        assertTrue(str.contains("PCLMULQDQ=true"));
        assertTrue(str.contains("SSE3=true"));
    }

    @Test
    public void testHasRAZ() {
        assertTrue(getFeaturesWithBitSet(31).hasRAZ());
    }

    @Test
    public void testHasF16C() {
        assertTrue(getFeaturesWithBitSet(29).hasF16C());
    }

    @Test
    public void testHasAVX() {
        assertTrue(getFeaturesWithBitSet(28).hasAVX());
    }

    @Test
    public void testHasOSXSAVE() {
        assertTrue(getFeaturesWithBitSet(27).hasOSXSAVE());
    }

    @Test
    public void testHasXSAVE() {
        assertTrue(getFeaturesWithBitSet(26).hasXSAVE());
    }

    @Test
    public void testHasAES() {
        assertTrue(getFeaturesWithBitSet(25).hasAES());
    }

    @Test
    public void testHasPOPCNT() {
        assertTrue(getFeaturesWithBitSet(23).hasPOPCNT());
    }

    @Test
    public void testHasSSE42() {
        assertTrue(getFeaturesWithBitSet(20).hasSSE42());
    }

    @Test
    public void testHasSSE41() {
        assertTrue(getFeaturesWithBitSet(19).hasSSE41());
    }

    @Test
    public void testHasCMPXCHG16B() {
        assertTrue(getFeaturesWithBitSet(13).hasCMPXCHG16B());
    }

    @Test
    public void testHasFMA() {
        assertTrue(getFeaturesWithBitSet(12).hasFMA());
    }

    @Test
    public void testHasSSSE3() {
        assertTrue(getFeaturesWithBitSet(9).hasSSSE3());
    }

    @Test
    public void testHasMONITOR() {
        assertTrue(getFeaturesWithBitSet(3).hasMONITOR());
    }

    @Test
    public void testHasPCLMULQDQ() {
        assertTrue(getFeaturesWithBitSet(1).hasPCLMULQDQ());
    }

    @Test
    public void testHasSSE3() {
        assertTrue(getFeaturesWithBitSet(0).hasSSE3());
    }

    private static FeatureIdentifiers getFeaturesWithBitSet(int offset) {
        return fromRegister(new Register(0b1 << offset));
    }

}
