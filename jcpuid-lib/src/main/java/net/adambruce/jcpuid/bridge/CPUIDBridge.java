package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.type.Result;

/**
 * Defines the required methods that a bridge must implement.
 */
public interface CPUIDBridge {

    /**
     * Executes the CPUID instruction with the given leaf node.
     *
     * @param leaf the leaf
     * @return the result containing register values and return value
     */
    Result executeCPUID(int leaf);
}
