package net.adambruce.type;

import java.util.Objects;

public class Result {
    private final int status;
    private final int eax;
    private final int ebx;
    private final int ecx;
    private final int edx;

    public Result(int status, int eax, int ebx, int ecx, int edx) {
        this.status = status;
        this.eax = eax;
        this.ebx = ebx;
        this.ecx = ecx;
        this.edx = edx;
    }

    public Status getStatus() {
        switch (status) {
            case 1:
                return Status.SUCCESS;
            default:
                return Status.FAILURE;
        }
    }

    public int getRawStatus() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Result)) {
            return false;
        }

        Result other = (Result) obj;

        return this.status == other.status &&
                this.eax == other.eax &&
                this.ebx== other.ebx &&
                this.ecx == other.ecx &&
                this.edx == other.edx;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, eax, ebx, ecx, edx);
    }
}
