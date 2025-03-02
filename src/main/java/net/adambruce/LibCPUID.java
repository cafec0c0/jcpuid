package net.adambruce;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class LibCPUID {

    private static boolean libLoaded = false;

    private LibCPUID() {

    }

    private static void unpackAndLoadLibrary() {
        if (!libLoaded) {
            try (InputStream libStream = LibCPUID.class.getResourceAsStream("/libcpuid.so")) {
                File out = File.createTempFile("libcpuid-", ".lib");
                Files.copy(libStream, out.getAbsoluteFile().toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.load(out.getAbsolutePath());
                libLoaded = true;
            } catch (IOException ex) {
                throw new RuntimeException("Unable to load library");
            }
        }
    }

    public static LibCPUID newInstance() {
        unpackAndLoadLibrary();
        return new LibCPUID();
    }

    public String getProcessorVendor() {
        CPUIDResult result = getCPUID(0x0000_0000);
        StringBuilder stringBuilder = new StringBuilder();
        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEbx() & (0xFF << shift)) >> shift));
        }
        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEdx() & (0xFF << shift)) >> shift));
        }
        for (int off = 0; off < 4; off++) {
            int shift = off * 8;
            stringBuilder.append((char)((result.getEcx() & (0xFF << shift)) >> shift));
        }
        return stringBuilder.toString();
    }

    public ProcessorFamily getProcessorFamily() {
        CPUIDResult result = getCPUID(0x0000_0001);
        int base = (result.getEax() & (0xF << 8)) >> 8;
        int ext = (result.getEax() & (0xFF << 20)) >> 20;
        return new ProcessorFamily(base, ext);
    }

    private native CPUIDResult getCPUID(int leaf);

}
