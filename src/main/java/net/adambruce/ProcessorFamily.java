package net.adambruce;

public class ProcessorFamily {
    private final int baseFamily;
    private final int extFamily;

    protected ProcessorFamily(int baseFamily, int extFamily) {
        this.baseFamily = baseFamily;
        this.extFamily = extFamily;
    }

    public int getBaseFamily() {
        return baseFamily;
    }

    public int getExtFamily() {
        return extFamily;
    }

    @Override
    public String toString() {
        return "ProcessorFamily{"
                + "base=0x" + Integer.toHexString(baseFamily) + ","
                + "ext=0x" + Integer.toHexString(extFamily)
                + "}";
    }
}
