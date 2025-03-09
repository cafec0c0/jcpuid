package net.adambruce.jcpuid;


import net.adambruce.jcpuid.exception.CPUIDException;
import net.adambruce.jcpuid.exception.InitialisationException;

public class PrintAllCPUIDInformation {

    private final CPUID cpuid;

    public static void main(String[] args) throws InitialisationException {
        new PrintAllCPUIDInformation().run();
    }

    private PrintAllCPUIDInformation() throws InitialisationException {
        cpuid = CPUIDFactory.getPlatformCPUID();
    }

    private void run() {
        printLargestStandardFunctionNumber();
        printProcessorVendor();
    }

    private void printLargestStandardFunctionNumber() {
        try {
            int largestInstructionNum = cpuid.getLargestStandardFunctionNumber();
            System.out.println("Largest Standard Function Number: " + largestInstructionNum);
        } catch (CPUIDException ex) {
            printException("getLargestStandardFunctionNumber", ex);
        }
    }

    private void printProcessorVendor() {
        try {
            System.out.println("Vendor: " + cpuid.getProcessorVendor());
        } catch (CPUIDException ex) {
            printException("getProcessorVendor", ex);
        }
    }

    private static void printException(String func, Exception ex) {
        System.out.println("====== Error executing CPUID instruction ======");
        System.out.println("Function: " + func);
        System.out.println("Stack Trace:");
        ex.printStackTrace(System.err);
        System.out.println("===============================================");
    }
}
