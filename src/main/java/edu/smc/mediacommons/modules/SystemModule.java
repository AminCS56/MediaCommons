package edu.smc.mediacommons.modules;

import java.io.File;

public class SystemModule {

    public static int getCores() {
        return Runtime.getRuntime().availableProcessors();
    }
    
    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }
    
    public static long getMaxMemory() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        return maxMemory == Long.MAX_VALUE ? maxMemory : maxMemory;
    }
    
    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }
    
    public static void listRoots() {
        File[] roots = File.listRoots();

        for (File root : roots) {
             System.out.println("File system root: " + root.getAbsolutePath());
             System.out.println("Total space (bytes): " + root.getTotalSpace());
             System.out.println("Free space (bytes): " + root.getFreeSpace());
             System.out.println("Usable space (bytes): " + root.getUsableSpace());
        }
    }
}