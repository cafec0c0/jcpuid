package net.adambruce.jcpuid;

public class CPUIDBitMasks {

    private CPUIDBitMasks() {

    }

    public static class Fn0000_0001_ECX {
        public static final int RAZ = 0b1 << 31;
        public static final int F16C = 0b1 << 29;
        public static final int AVX = 0b1 << 28;
        public static final int OSXSAVE = 0b1 << 27;
        public static final int XSAVE = 0b1 << 26;
        public static final int AES = 0b1 << 25;
        public static final int POPCNT = 0b1 << 23;
        public static final int SSE42 = 0b1 << 20;
        public static final int SSE41 = 0b1 << 19;
        public static final int CMPXCHG16B = 0b1 << 13;
        public static final int FMA = 0b1 << 12;
        public static final int SSSE3 = 0b1 << 9;
        public static final int MONITOR = 0b1 << 3;
        public static final int PCLMULQDQ = 0b1 << 1;
        public static final int SSE3 = 0b1;
    }

    public static class Fn0000_0001_EDX {
        public static final int HTT = 0b1 << 28;
        public static final int SSE2 = 0b1 << 26;
        public static final int SSE = 0b1 << 25;
        public static final int FXSR = 0b1 << 24;
        public static final int MMX = 0b1 << 23;
        public static final int CLFSH = 0b1 << 19;
        public static final int PSE36 = 0b1 << 17;
        public static final int PAT = 0b1 << 16;
        public static final int CMOV = 0b1 << 15;
        public static final int MCA = 0b1 << 14;
        public static final int PGE = 0b1 << 13;
        public static final int MTRR = 0b1 << 12;
        public static final int SysEnterSysExit = 0b1 << 11;
        public static final int APIC = 0b1 << 9;
        public static final int CMPXCHG8B = 0b1 << 8;
        public static final int MCE = 0b1 << 7;
        public static final int PAE = 0b1 << 6;
        public static final int MSR = 0b1 << 5;
        public static final int TSC = 0b1 << 4;
        public static final int PSE = 0b1 << 3;
        public static final int DE = 0b1 << 2;
        public static final int VME = 0b1 << 1;
        public static final int FPU = 0b1;
    }

}
