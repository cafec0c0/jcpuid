package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.exception.PlatformNotSupportedException;
import net.adambruce.jcpuid.type.Result;

public interface CPUIDBridge {

    static CPUIDBridge getPlatformBridge() throws PlatformNotSupportedException {
        return new Amd64CPUIDBridgeImpl();
    }

    Result getCPUID(int leaf);
}