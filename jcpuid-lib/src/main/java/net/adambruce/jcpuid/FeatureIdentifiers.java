package net.adambruce.jcpuid;

import java.util.Objects;

public class FeatureIdentifiers {

    private boolean raz;
    private boolean f16c;
    private boolean avx;
    private boolean osxsave;
    private boolean xsave;
    private boolean aes;
    private boolean popcnt;
    private boolean sse42;
    private boolean sse41;
    private boolean cmpxchg16b;
    private boolean fma;
    private boolean ssse3;
    private boolean monitor;
    private boolean pclmulqdq;
    private boolean sse3;

    private FeatureIdentifiers() {

    }


    FeatureIdentifiers(boolean raz, boolean f16c, boolean avx,
                              boolean osxsave, boolean xsave, boolean aes,
                              boolean popcnt, boolean sse42, boolean sse41,
                              boolean cmpxchg16b, boolean fma, boolean ssse3,
                              boolean monitor, boolean pclmulqdq, boolean sse3) {
        this.raz = raz;
        this.f16c = f16c;
        this.avx = avx;
        this.osxsave = osxsave;
        this.xsave = xsave;
        this.aes = aes;
        this.popcnt = popcnt;
        this.sse42 = sse42;
        this.sse41 = sse41;
        this.cmpxchg16b = cmpxchg16b;
        this.fma = fma;
        this.ssse3 = ssse3;
        this.monitor = monitor;
        this.pclmulqdq = pclmulqdq;
        this.sse3 = sse3;
    }

    public boolean isRAZ() {
        return raz;
    }

    public boolean isF16C() {
        return f16c;
    }

    public boolean isAVX() {
        return avx;
    }

    public boolean isOSXSAVE() {
        return osxsave;
    }

    public boolean isXSAVE() {
        return xsave;
    }

    public boolean isAES() {
        return aes;
    }

    public boolean isPOPCNT() {
        return popcnt;
    }

    public boolean isSSE42() {
        return sse42;
    }

    public boolean isSSE41() {
        return sse41;
    }

    public boolean isCMPXCHG16B() {
        return cmpxchg16b;
    }

    public boolean isFMA() {
        return fma;
    }

    public boolean isSSSE3() {
        return ssse3;
    }

    public boolean isMONITOR() {
        return monitor;
    }

    public boolean isPCLMULQDQ() {
        return pclmulqdq;
    }

    public boolean isSSE3() {
        return sse3;
    }

    @Override
    public String toString() {
        return "FeatureIdentifiers{" +
                "raz=" + raz +
                ", f16c=" + f16c +
                ", avx=" + avx +
                ", osxsave=" + osxsave +
                ", xsave=" + xsave +
                ", aes=" + aes +
                ", popcnt=" + popcnt +
                ", sse42=" + sse42 +
                ", sse41=" + sse41 +
                ", cmpxchg16b=" + cmpxchg16b +
                ", fma=" + fma +
                ", ssse3=" + ssse3 +
                ", monitor=" + monitor +
                ", pclmulqdq=" + pclmulqdq +
                ", sse3=" + sse3 +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof FeatureIdentifiers)) {
            return false;
        }

        FeatureIdentifiers that = (FeatureIdentifiers) obj;

        return this.raz == that.raz &&
                this.f16c == that.f16c &&
                this.avx == that.avx &&
                this.osxsave == that.osxsave &&
                this.xsave == that.xsave &&
                this.aes == that.aes &&
                this.popcnt == that.popcnt &&
                this.sse42 == that.sse42 &&
                this.sse41 == that.sse41 &&
                this.cmpxchg16b == that.cmpxchg16b &&
                this.fma == that.fma &&
                this.ssse3 == that.ssse3 &&
                this.monitor == that.monitor &&
                this.pclmulqdq == that.pclmulqdq &&
                this.sse3 == that.sse3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(raz, f16c, avx, osxsave, xsave, aes, popcnt, sse42,
                sse41, cmpxchg16b, fma, ssse3, monitor, pclmulqdq, sse3);
    }
}
