package net.adambruce.bridge;

import net.adambruce.CPUIDImpl;
import net.adambruce.type.Result;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Amd64CPUIDBridgeImpl implements CPUIDBridge {

    private static final String LIB_PATH = "/net/adambruce/cpuid/natives/jcpuid-linux-x86_64.so";
    private static boolean libLoaded = false;

    public Amd64CPUIDBridgeImpl() {
        init();
    }

    private static void init() {
        if (!libLoaded) {
            try (InputStream libStream = CPUIDImpl.class.getResourceAsStream(LIB_PATH)) {
                File out = File.createTempFile("jcpuid-", ".so");
                Files.copy(libStream, out.getAbsoluteFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.load(out.getAbsolutePath());
                libLoaded = true;
            } catch (IOException ex) {
                throw new RuntimeException("Unable to load library");
            }
        }
    }

    @Override
    public Result getCPUID(int leaf) {
        return getCPUIDNative(leaf);
    }

    private native Result getCPUIDNative(int leaf);
}
