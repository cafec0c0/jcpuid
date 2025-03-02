package net.adambruce.bridge;

import net.adambruce.exception.PlatformNotSupportedException;
import net.adambruce.type.Result;

public interface CPUIDBridge {

    static CPUIDBridge getPlatformBridge() throws PlatformNotSupportedException {
        return new Amd64CPUIDBridgeImpl();
    }

    Result getCPUID(int leaf);
}