package net.adambruce.jcpuid.bridge;

import net.adambruce.jcpuid.CPUIDImpl;
import net.adambruce.jcpuid.type.Result;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Amd64CPUIDBridgeImpl implements CPUIDBridge {

    private static final String LIB_PATH = "net/adambruce/jcpuid/lib/jcpuid-native-linux-1.0-SNAPSHOT.so";
    private static boolean libLoaded = false;

    public Amd64CPUIDBridgeImpl() {
        init();
    }

    private void init() {
        if (!libLoaded) {
            try (InputStream libStream = getClass().getClassLoader().getResourceAsStream(LIB_PATH)) {
                File out = File.createTempFile("jcpuid-native-linux-", ".so");
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
