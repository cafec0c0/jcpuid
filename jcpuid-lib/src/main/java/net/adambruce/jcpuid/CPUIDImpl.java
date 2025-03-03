package net.adambruce.jcpuid;

import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.exception.PlatformNotSupportedException;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.type.Status;

public class CPUIDImpl implements CPUID {

    private final CPUIDBridge bridge;

    public CPUIDImpl() throws PlatformNotSupportedException {
        this(CPUIDBridge.getPlatformBridge());
    }

    public CPUIDImpl(CPUIDBridge bridge) {
        this.bridge = bridge;
    }

    @Override
    public int getLargestStandardFunctionNumber() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0000);
        assertStatus(result);

        return result.getEax();
    }

    @Override
    public String getProcessorVendor() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0000);
        assertStatus(result);

        StringBuilder stringBuilder = new StringBuilder();
        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEbx() & (0xFF << shift)) >> shift));
        }

        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEdx() & (0xFF << shift)) >> shift));
        }

        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEcx() & (0xFF << shift)) >> shift));
        }

        return stringBuilder.toString();
    }

    @Override
    public int getProcessorFamily() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        int base = (result.getEax() & (0xF << 8)) >> 8;
        int ext = (result.getEax() & (0xFF << 20)) >> 20;

        if (base < 0xF) {
            return base;
        }

        return base + ext;
    }

    @Override
    public int getProcessorStepping() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return result.getEax() & 0xF;
    }

    @Override
    public int getProcessorModel() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        int base = (result.getEax() & (0xF << 4)) >> 4;
        int ext = (result.getEax() & (0xF << 16)) >> 16;

        if (base < 0xF) {
            return base;
        }

        return (ext << 4) | base;
    }

    @Override
    public int getLocalApicId() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return (result.getEbx() & (0xFF << 24)) >> 24;
    }

    @Override
    public int getLogicalProcessorCount() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        // TODO come back to this once 8000* functions are implemented, as this
//        if (!FeatureIdentifiers.BitMasks.HTT.isBitSet(result.getEdx())) {
            // hyperthreading is disabled, this is reserved
//            throw new CPUIDException("The register is reserved on this processor");
//        }

        // hyperthreading is enabled, number of cores per processor
        return (result.getEbx() & (0xFF << 16)) >> 16;
    }

    @Override
    public int getCLFLUSHCacheLineSize() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return (result.getEbx() & (0xFF << 8)) >> 8;
    }

    @Override
    public String getProcessorNameString() throws CPUIDException {
        // TODO (uses fn8000_0001)
        return "TODO";
    }

    @Override
    public FeatureIdentifiers getFeatureIdentifiers() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return new FeatureIdentifiers(
                (result.getEcx() & (0b1 << 31)) != 0,
                (result.getEcx() & (0b1 << 29)) != 0,
                (result.getEcx() & (0b1 << 28)) != 0,
                (result.getEcx() & (0b1 << 27)) != 0,
                (result.getEcx() & (0b1 << 26)) != 0,
                (result.getEcx() & (0b1 << 25)) != 0,
                (result.getEcx() & (0b1 << 23)) != 0,
                (result.getEcx() & (0b1 << 20)) != 0,
                (result.getEcx() & (0b1 << 19)) != 0,
                (result.getEcx() & (0b1 << 13)) != 0,
                (result.getEcx() & (0b1 << 12)) != 0,
                (result.getEcx() & (0b1 << 9)) != 0,
                (result.getEcx() & (0b1 << 3)) != 0,
                (result.getEcx() & (0b1 << 1)) != 0,
                (result.getEcx() & 0b1) != 0
        );
    }

    @Override
    public Result getRawCPUID(int leaf) {
        return bridge.getCPUID(leaf);
    }

    private static void assertStatus(Result result) throws CPUIDException {
        // GCC will return 1 on success
        if (result.getStatus() != Status.SUCCESS) {
            throw new CPUIDException("the CPUID instruction failed with status " + result.getRawStatus());
        }
    }

}
