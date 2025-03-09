package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.type.Result;

/**
 * The default implementation of the CPUIDBridge interface.
 */
public class DefaultCPUIDBridge implements CPUIDBridge {

    /**
     * Executes the CPUID instruction using the given leaf.
     *
     * @param leaf the leaf
     * @return the result of the CPUID instruction execution
     */
    @Override
    public Result executeCPUID(final int leaf) {
        return executeCPUIDNative(leaf);
    }

    private native Result executeCPUIDNative(int leaf);
}
