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

import java.util.Objects;

/**
 * The feature identifiers returned by the processor.
 */
public class FeatureIdentifiers {

    /** Bit position for the RAZ feature. */
    private static final int RAZ_BIT = 31;

    /** Bit position for the F16C feature. */
    private static final int F16C_BIT = 29;

    /** Bit position for the AVX feature. */
    private static final int AVX_BIT = 28;

    /** Bit position for the OSXSAVE / XSAVE features. */
    private static final int OSXSAVE_BIT = 27;

    /** Bit position for the XSAVE feature. */
    private static final int XSAVE_BIT = 26;

    /** Bit position for the AES feature. */
    private static final int AES_BIT = 25;

    /** Bit position for the POPCNT feature. */
    private static final int POPCNT_BIT = 23;

    /** Bit position for the SSE4.2 feature. */
    private static final int SSE42_BIT = 20;

    /** Bit position for the SSE4.1 feature. */
    private static final int SSE41_BIT = 19;

    /** Bit position for the CMPXCHG16B feature. */
    private static final int CMPXCHG16B_BIT = 13;

    /** Bit position for the FMA feature. */
    private static final int FMA_BIT = 12;

    /** Bit position for the SSSE3 feature. */
    private static final int SSSE3_BIT = 9;

    /** Bit position for the MONITOR/MWAIT features. */
    private static final int MONITOR_BIT = 3;

    /** Bit position for the PCLMULQDQ feature. */
    private static final int PCLMULQDQ_BIT = 1;

    /** Bit position for the SSE3 feature. */
    private static final int SSE3_BIT = 0;


    /** The processor supports the RAZ feature. **/
    private boolean raz;

    /** The processor supports the F16C feature. **/
    private boolean f16c;

    /** The processor supports the AVX feature. **/
    private boolean avx;

    /** The processor supports the OSXSAVE / XSAVE features. **/
    private boolean osxsave;

    /** The processor supports the XSAVE feature. **/
    private boolean xsave;

    /** The processor supports the AES feature. **/
    private boolean aes;

    /** The processor supports the POPCNT feature. **/
    private boolean popcnt;

    /** The processor supports the SSE4.2 feature. **/
    private boolean sse42;

    /** The processor supports the SSE4.1 feature. **/
    private boolean sse41;

    /** The processor supports the CMPXCHG16B feature. **/
    private boolean cmpxchg16b;

    /** The processor supports the FMA feature. **/
    private boolean fma;

    /** The processor supports the SSSE3 feature. **/
    private boolean ssse3;

    /** The processor supports the MONITOR feature. **/
    private boolean monitor;

    /** The processor supports the PCLMULQDQ feature. **/
    private boolean pclmulqdq;

    /** The processor supports the SSE3 feature. **/
    private boolean sse3;


    /**
     * Create a new instance from the provided register value.
     *
     * @param register the register to use for determining supported features
     * @return the supported feature identifiers
     */
    public static FeatureIdentifiers fromRegister(final Register register) {
        int value = register.getIntValue();
        FeatureIdentifiers featureIdentifiers = new FeatureIdentifiers();
        featureIdentifiers.raz = (value & (0b1 << RAZ_BIT)) != 0;
        featureIdentifiers.avx = (value & (0b1 << AVX_BIT)) != 0;
        featureIdentifiers.f16c = (value & (0b1 << F16C_BIT)) != 0;
        featureIdentifiers.osxsave = (value & (0b1 << OSXSAVE_BIT)) != 0;
        featureIdentifiers.xsave = (value & (0b1 << XSAVE_BIT)) != 0;
        featureIdentifiers.aes = (value & (0b1 << AES_BIT)) != 0;
        featureIdentifiers.popcnt = (value & (0b1 << POPCNT_BIT)) != 0;
        featureIdentifiers.sse42 = (value & (0b1 << SSE42_BIT)) != 0;
        featureIdentifiers.sse41 = (value & (0b1 << SSE41_BIT)) != 0;
        featureIdentifiers.cmpxchg16b = (value & (0b1 << CMPXCHG16B_BIT)) != 0;
        featureIdentifiers.fma = (value & (0b1 << FMA_BIT)) != 0;
        featureIdentifiers.ssse3 = (value & (0b1 << SSSE3_BIT)) != 0;
        featureIdentifiers.monitor = (value & (0b1 << MONITOR_BIT)) != 0;
        featureIdentifiers.pclmulqdq = (value & (0b1 << PCLMULQDQ_BIT)) != 0;
        featureIdentifiers.sse3 = (value & (0b1 << SSE3_BIT)) != 0;
        return featureIdentifiers;
    }

    /**
     * Is the RAZ feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasRAZ() {
        return raz;
    }

    /**
     * Is the F16C feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasF16C() {
        return f16c;
    }

    /**
     * Is the AVX feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasAVX() {
        return avx;
    }

    /**
     * Are the OSXSAVE / XSAVE features supported.
     *
     * @return true if the features are supported, otherwise false
     */
    public boolean hasOSXSAVE() {
        return osxsave;
    }

    /**
     * Is the XSAVE feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasXSAVE() {
        return xsave;
    }

    /**
     * Is the AES feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasAES() {
        return aes;
    }

    /**
     * Is the POPCNT feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasPOPCNT() {
        return popcnt;
    }

    /**
     * Is the SSE4.2 feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasSSE42() {
        return sse42;
    }

    /**
     * Is the SSE4.1 feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasSSE41() {
        return sse41;
    }

    /**
     * Is the CMPXCHG16B feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasCMPXCHG16B() {
        return cmpxchg16b;
    }

    /**
     * Is the FMA feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasFMA() {
        return fma;
    }

    /**
     * Is the SSSE3 feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasSSSE3() {
        return ssse3;
    }

    /**
     * Are the MONITOR / MWAIT features supported.
     *
     * @return true if the features are supported, otherwise false
     */
    public boolean hasMONITOR() {
        return monitor;
    }

    /**
     * Is the PCLMULQDQ feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasPCLMULQDQ() {
        return pclmulqdq;
    }

    /**
     * Is the SSE3 feature supported.
     *
     * @return true if the feature is supported, otherwise false
     */
    public boolean hasSSE3() {
        return sse3;
    }

    /**
     * Returns the string representation of this set of feature identifiers.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "FeatureIdentifiers{"
                + "RAZ=" + raz
                + ", F16C=" + f16c
                + ", AVX=" + avx
                + ", OSXSAVE=" + osxsave
                + ", XSAVE=" + xsave
                + ", AES=" + aes
                + ", POPCNT=" + popcnt
                + ", SSE4.2=" + sse42
                + ", SSE4.1=" + sse41
                + ", CMPXCHG16B=" + cmpxchg16b
                + ", FMA=" + fma
                + ", SSSE3=" + ssse3
                + ", MONITOR=" + monitor
                + ", PCLMULQDQ=" + pclmulqdq
                + ", SSE3=" + sse3
                + "}";
    }

    /**
     * Compares this set of feature identifiers with the given set of feature
     * identifiers. All identifiers will be compared.
     *
     * @param obj the other set of feature identifiers
     * @return whether this set is equal to the other set
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof FeatureIdentifiers)) {
            return false;
        }

        FeatureIdentifiers that = (FeatureIdentifiers) obj;

        return this.raz == that.raz
                && this.f16c == that.f16c
                && this.avx == that.avx
                && this.osxsave == that.osxsave
                && this.xsave == that.xsave
                && this.aes == that.aes
                && this.popcnt == that.popcnt
                && this.sse42 == that.sse42
                && this.sse41 == that.sse41
                && this.cmpxchg16b == that.cmpxchg16b
                && this.fma == that.fma
                && this.ssse3 == that.ssse3
                && this.monitor == that.monitor
                && this.pclmulqdq == that.pclmulqdq
                && this.sse3 == that.sse3;
    }

    /**
     * Generates the hash code for this set of feature identifiers using the
     * status and registers.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(raz, f16c, avx, osxsave, xsave, aes, popcnt, sse42,
                sse41, cmpxchg16b, fma, ssse3, monitor, pclmulqdq, sse3);
    }
}
