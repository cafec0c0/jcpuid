package net.adambruce;

public class CPUIDResult {
    private final int status;
    private final int eax;
    private final int ebx;
    private final int ecx;
    private final int edx;

    public CPUIDResult(int status, int eax, int ebx, int ecx, int edx) {
        this.status = status;
        this.eax = eax;
        this.ebx = ebx;
        this.ecx = ecx;
        this.edx = edx;
    }

    public int getStatus() {
        return status;
    }

    public int getEax() {
        return eax;
    }

    public int getEbx() {
        return ebx;
    }

    public int getEcx() {
        return ecx;
    }

    public int getEdx() {
        return edx;
    }

    @Override
    public String toString() {
        return "CpuidResult{"
                + "status=0x" + Integer.toHexString(status) + ","
                + "eax=0x" + Integer.toHexString(eax) + ","
                + "ebx=0x" + Integer.toHexString(ebx) + ","
                + "ecx=0x" + Integer.toHexString(ecx) + ","
                + "edx=0x" + Integer.toHexString(edx)
                + "}";
    }
}
