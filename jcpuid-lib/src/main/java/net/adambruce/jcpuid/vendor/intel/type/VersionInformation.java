package net.adambruce.jcpuid.vendor.intel.type;

import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.type.Register;

import java.util.Objects;

/**
 * Holds version information about Intel processors.
 */
public class VersionInformation {

    /** Bit offset for stepping. */
    private static final int STEPPING_OFFSET = 0;

    /** Bit offset for model. */
    private static final int MODEL_OFFSET = 4;

    /** Bit offset for family. */
    private static final int FAMILY_OFFSET = 8;

    /** Bit offset for processor type. */
    private static final int PROCESSOR_TYPE_OFFSET = 12;

    /** Bit offset for extended model. */
    private static final int EXTENDED_MODEL_OFFSET = 16;

    /** Bit offset for extended family. */
    private static final int EXTENDED_FAMILY_OFFSET = 20;

    /** Lower family ID indicating extended family. */
    private static final int LOWER_FAMILY_EXTENDED = 0x6;

    /** Higher family ID indicating extended family. */
    private static final int HIGHER_FAMILY_EXTENDED = 0xf;

    /**
     * Number of bits to shift the extended model ID when calculating the
     * display model ID.
     */
    private static final int EXTENDED_MODEL_SHIFT = 4;


    /** The processor family. */
    private final int family;

    /** The processor model. */
    private final int model;

    /** The processor stepping. */
    private final int stepping;

    /** The processor type. */
    private final ProcessorType type;

    /** The extended model. */
    private final int extendedModel;

    /** The extended family. */
    private final int extendedFamily;

    /**
     * Create a new instance from the given register.
     *
     * @param eax the eax register
     * @throws CPUIDException a bit field contained an invalid value.
     */
    public VersionInformation(final Register eax) throws CPUIDException {
        this.stepping = eax.getNibbleValue(STEPPING_OFFSET);
        this.model = eax.getNibbleValue(MODEL_OFFSET);
        this.family = eax.getNibbleValue(FAMILY_OFFSET);
        this.type = getProcessorTypeFromRegister(eax);
        this.extendedModel = eax.getNibbleValue(EXTENDED_MODEL_OFFSET);
        this.extendedFamily = eax.getByteValue(EXTENDED_FAMILY_OFFSET);
    }

    /**
     * Returns the processor's family.
     *
     * @return the family.
     */
    public int getFamily() {
        return family;
    }

    /**
     * Returns the processor's model.
     *
     * @return the model.
     */
    public int getModel() {
        return model;
    }

    /**
     * Returns the processor's stepping.
     *
     * @return the stepping.
     */
    public int getStepping() {
        return stepping;
    }

    /**
     * Returns the processor's type.
     *
     * @return the type.
     */
    public ProcessorType getType() {
        return type;
    }

    /**
     * Returns the processor's extended model.
     *
     * @return the extended model.
     */
    public int getExtendedModel() {
        return extendedModel;
    }

    /**
     * Returns the processor's extended family.
     *
     * @return the extended family.
     */
    public int getExtendedFamily() {
        return extendedFamily;
    }

    /**
     * Returns the processor's display model (calculated using the family, model
     * and extended model as per Intel's rule).
     *
     * @return the display model.
     */
    public int getDisplayModel() {
        if (family == LOWER_FAMILY_EXTENDED
                || family == HIGHER_FAMILY_EXTENDED) {
            return (extendedModel << EXTENDED_MODEL_SHIFT) + model;
        }

        return model;
    }

    /**
     * Returns the processor's display family (calculated using the family and
     * extended family as per Intel's rule).
     *
     * @return the display family.
     */
    public int getDisplayFamily() {
        if (family != HIGHER_FAMILY_EXTENDED) {
            return family;
        }

        return extendedFamily + family;
    }

    private ProcessorType getProcessorTypeFromRegister(final Register register)
            throws CPUIDException {
        int lowerBit = register.getBitValue(PROCESSOR_TYPE_OFFSET);
        int higherBit = register.getBitValue(PROCESSOR_TYPE_OFFSET + 1);
        return ProcessorType.from(lowerBit | (higherBit << 1));
    }

    /**
     * Compares this version information with the given version information.
     * Stepping, model, family, type, extended model and extended family will
     * be compared.
     *
     * @param obj the other version information
     * @return whether this version information is equal to the other version
     * information
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof VersionInformation)) {
            return false;
        }

        VersionInformation that = (VersionInformation) obj;

        return this.stepping == that.stepping
                && this.model == that.model
                && this.family == that.family
                && this.type == that.type
                && this.extendedModel == that.extendedModel
                && this.extendedFamily == that.extendedFamily;
    }

    /**
     * Returns the string representation of this register.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        return "VersionInformation{"
                + "stepping=0x" + Integer.toHexString(stepping) + ","
                + "model=0x" + Integer.toHexString(model) + ","
                + "family=0x" + Integer.toHexString(family) + ","
                + "type=" + type + ","
                + "extendedModel=0x" + Integer.toHexString(extendedModel) + ","
                + "extendedFamily=0x" + Integer.toHexString(extendedFamily)
                + "}";
    }

    /**
     * Generates the hash code for this version information using the stepping,
     * model, family, type, extended model and extended family.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(stepping, model, family, type, extendedModel,
                extendedFamily);
    }
}
