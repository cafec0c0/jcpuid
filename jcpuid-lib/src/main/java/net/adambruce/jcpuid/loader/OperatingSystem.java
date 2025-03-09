package net.adambruce.jcpuid.loader;

/**
 * Operating systems supported by JCPUID.
 */
public enum OperatingSystem {

    /** The Linux operating system. */
    LINUX("linux"),

    /** The Windows operating system. */
    MACOS("macos"),

    /** The MacOS operating system. */
    WINDOWS("windows");

    /** The name of the operating system (used for locating native library). */
    private final String name;

    OperatingSystem(final String lookupName) {
        this.name = lookupName;
    }

    /**
     * Gets the name of the operating system for the purposes of locating the
     * native library on the class path.
     *
     * @return the name of the operating system
     */
    public String getLookupName() {
        return name;
    }
}
