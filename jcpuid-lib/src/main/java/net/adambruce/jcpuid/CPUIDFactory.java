package net.adambruce.jcpuid;

import net.adambruce.jcpuid.bridge.CPUIDBridgeFactory;
import net.adambruce.jcpuid.exception.InitialisationException;

public final class CPUIDFactory {

    private CPUIDFactory() {

    }

    /**
     * Gets the CPUID implementation for the current platform, loading the
     * native library if it has not already been loaded into the current JVM.
     * The native library to be loaded will be determined based on the values
     * returned in the <code>os.arch</code> and <code>os.name</code> JVM
     * properties.
     *
     * @return the CPUID implementation for the current platform
     * @throws InitialisationException the platform CPUID implementation failed
     * to initialise.
     */
    static CPUID getPlatformCPUID() throws InitialisationException {
        if (System.getProperty("os.arch").equals("amd64")) {
            return new DefaultCPUID(CPUIDBridgeFactory.getPlatformBridge());
        }
        throw new InitialisationException("this platform is not supported");
    }

}
