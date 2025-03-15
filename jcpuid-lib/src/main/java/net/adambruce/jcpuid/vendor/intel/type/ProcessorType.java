package net.adambruce.jcpuid.vendor.intel.type;

import net.adambruce.jcpuid.exception.CPUIDException;

/**
 * Intel processor types.
 */
public enum ProcessorType {

    /** Original OEM Processor. */
    ORIGINAL_OEM_PROCESSOR(0b00),

    /** Intel OverDrive Processor. */
    INTEL_OVERDRIVE_PROCESSOR(0b01),

    /** Dual Processor (not applicable to Intel486 processors). */
    DUAL_PROCESSOR(0b10),

    /** Intel reserved. */
    INTEL_RESERVED(0b11);

    /** The integer value of the processor type encoding. */
    private final int encodingValue;

    ProcessorType(final int encoding) {
        this.encodingValue = encoding;
    }

    /**
     * Get the processor type from it's encoding.
     *
     * @param encoding the encoding
     * @return the processor type
     * @throws CPUIDException the encoding did not match any known processor
     * types
     */
    public static ProcessorType from(final int encoding) throws CPUIDException {
        if (encoding == ORIGINAL_OEM_PROCESSOR.getEncoding()) {
            return ORIGINAL_OEM_PROCESSOR;
        }

        if (encoding == INTEL_OVERDRIVE_PROCESSOR.getEncoding()) {
            return INTEL_OVERDRIVE_PROCESSOR;
        }

        if (encoding == DUAL_PROCESSOR.getEncoding()) {
            return DUAL_PROCESSOR;
        }

        if (encoding == INTEL_RESERVED.getEncoding()) {
            return INTEL_RESERVED;
        }

        throw new CPUIDException("Unknown processor type.");
    }

    /**
     * Get the encoding for this processor type.
     *
     * @return the encoding
     */
    public int getEncoding() {
        return encodingValue;
    }
}
