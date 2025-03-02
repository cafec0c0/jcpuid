package net.adambruce;

public class Main {

    public static void main(String[] args) {
        LibCPUID cpuid = LibCPUID.newInstance();
        System.out.println("Vendor: " + cpuid.getProcessorVendor());
        System.out.println("Family: " + cpuid.getProcessorFamily());
    }



}
