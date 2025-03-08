package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.exception.InitialisationException;
import net.adambruce.jcpuid.type.Result;

/**
 * Defines the required methods that a bridge must implement.
 */
public interface CPUIDBridge {

    /**
     * Returns the correct bridge for the current platform.
     *
     * @return the CPUID bridge for the current platform
     * @throws InitialisationException no bridged were found for the platform
     */
    static CPUIDBridge getPlatformBridge() throws InitialisationException {
        return new DefaultCPUIDBridge();
    }

    /**
     * Executes the CPUID instruction with the given leaf node.
     *
     * @param leaf the leaf
     * @return the result containing register values and return value
     */
    Result executeCPUID(int leaf);
}
