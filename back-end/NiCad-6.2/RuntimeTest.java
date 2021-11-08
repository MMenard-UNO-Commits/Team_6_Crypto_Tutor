package com;

import java.lang.Process;
import java.lang.Runtime;

public class RuntimeTest {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try {
            Runtime rt = Runtime.getRuntime();
            /*String[] cmd = { "/Users/michaelmenard/desktop/NiCad-6.2/nicad6",
                    " functions java Users/michaelmenard/desktop/NiCad-6.2/systems/JHotDraw default-report" };*/

            String[] cmd = {"ls", "-a", "-l"};
            Process pr = rt.exec(cmd);
            int retval = pr.waitFor();
            System.out.println(retval);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
