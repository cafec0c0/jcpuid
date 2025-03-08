package net.adambruce.jcpuid;

import net.adambruce.jcpuid.bridge.CPUIDBridge;
import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.type.Result;
import net.adambruce.jcpuid.type.Status;

public class DefaultCPUID implements CPUID {

    /** Bit shift constant for 4 bits. */
    private static final int FOUR_BITS = 4;

    /** Bit shift constant for 8 bits. */
    private static final int EIGHT_BITS = 8;

    /** Bit shift constant for 12 bits. */
    private static final int TWELVE_BITS = 12;

    /** Bit shift constant for 16 bits. */
    private static final int SIXTEEN_BITS = 16;

    /** Bit shift constant for 20 bits. */
    private static final int TWENTY_BITS = 20;

    /** Bit shift constant for 24 bits. */
    private static final int TWENTY_FOUR_BITS = 24;

    /** Bit shift constant for 28 bits. */
    private static final int TWENTY_EIGHT_BITS = 28;

    /** The size of EAX,EBX,ECX and EDX registers. */
    private static final int FOUR_BYTES = 4;

    /** The number of bits per byte. */
    private static final int BITS_PER_BYTE = 8;

    /** The bit mask for a nibble. */
    private static final int NIBBLE_MASK = 0xF;

    /** The bit mask for a byte. */
    private static final int BYTE_MASK = 0xFF;

    /** The maximum value that a nibble can hold. */
    private static final int MAX_NIBBLE_VALUE = 0xF;

    /** The bridge used to execute native CPUID instructions. */
    private final CPUIDBridge bridgeImpl;

    /**
     * Create a new CPUID instance for the current platform.
     *
     * @throws InitialisationException the platform CPUID implementation failed
     */
    public DefaultCPUID() throws InitialisationException {
        this(CPUIDBridge.getPlatformBridge());
    }

    /**
     * Create a new CPUID instance for using the provided bridge.
     *
     * @param bridge the bridge to use
     */
    public DefaultCPUID(final CPUIDBridge bridge) {
        this.bridgeImpl = bridge;
    }

    /**
     * Obtains the largest standard function number supported by the processor.
     *
     * @return the largest standard function number
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getLargestStandardFunctionNumber() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0000);
        assertStatus(result);

        return result.getEax().getIntValue();
    }

    /**
     * Obtains the processor vendor string.
     *
     * @return the processor vendor string
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public String getProcessorVendor() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0000);
        assertStatus(result);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(result.getEbx().getStringValue());
        stringBuilder.append(result.getEdx().getStringValue());
        stringBuilder.append(result.getEcx().getStringValue());

        return stringBuilder.toString();
    }

    /**
     * Obtains the processor family.
     *
     * @return the processor family
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getProcessorFamily() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        int base = (result.getEax().getIntValue() >> EIGHT_BITS) & NIBBLE_MASK;
        int ext = (result.getEax().getIntValue() >> TWENTY_BITS) & BYTE_MASK;

        if (base < MAX_NIBBLE_VALUE) {
            return base;
        }

        return base + ext;
    }

    /**
     * Obtains the processor stepping (revision number).
     *
     * @return the processor stepping
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getProcessorStepping() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return result.getEax().getIntValue() & NIBBLE_MASK;
    }

    /**
     * Obtains the processor model.
     *
     * @return the processor model
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getProcessorModel() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        int base = (result.getEax().getIntValue() >> FOUR_BITS) & NIBBLE_MASK;
        int ext = (result.getEax().getIntValue() >> SIXTEEN_BITS) & NIBBLE_MASK;

        if (base < NIBBLE_MASK) {
            return base;
        }

        return (ext << FOUR_BITS) | base;
    }

    /**
     * Obtains the local APIC ID.
     *
     * @return the local APIC ID
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getLocalApicId() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return (result.getEbx().getIntValue() >> TWENTY_FOUR_BITS) & BYTE_MASK;
    }

    /**
     * Obtains the logical processor count.
     *
     * @return the logical processor count
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getLogicalProcessorCount() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        // TODO come back to this once 8000* functions are implemented, as this
//        if (!FeatureIdentifiers.BitMasks.HTT.isBitSet(result.getEdx())) {
            // hyperthreading is disabled, this is reserved
//            throw new CPUIDException("The register is reserved on this
//            processor");
//        }

        // hyperthreading is enabled, number of cores per processor
        return (result.getEbx().getIntValue() >> SIXTEEN_BITS) & BYTE_MASK;
    }

    /**
     * Obtains the size of a cache line in quadwords flushed by the CLFLUSH
     * instruction.
     *
     * @return the size of the cache line in quadwords
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public int getCLFLUSHCacheLineSize() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);

        return (result.getEbx().getIntValue() >> EIGHT_BITS) & BYTE_MASK;
    }

    /**
     * Obtains the processor name string.
     *
     * @return the processor name string
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public String getProcessorNameString() {
        // TODO (uses fn8000_0001)
        return "TODO";
    }

    /**
     * Obtains the feature identifiers.
     *
     * @return the feature processor's feature availability
     * @throws CPUIDException the native cpuid execution failed
     */
    @Override
    public FeatureIdentifiers getFeatureIdentifiers() throws CPUIDException {
        Result result = getRawCPUID(0x0000_0001);
        assertStatus(result);
        return FeatureIdentifiers.fromRegister(result.getEcx());
    }

    /**
     * Executes the CPUID instruction with the given leaf.
     * You should avoid using this function if possible.
     *
     * @param leaf the leaf of the CPUID instruction
     * @return the result of the CPUID execution
     */
    @Override
    public Result getRawCPUID(final int leaf) {
        return bridgeImpl.executeCPUID(leaf);
    }

    private static void assertStatus(final Result result)
            throws CPUIDException {
        // GCC will return 1 on success
        if (result.getStatus() != Status.SUCCESS) {
            throw new CPUIDException("the CPUID instruction failed with status "
                    + result.getStatus().getIntValue());
        }
    }

}
