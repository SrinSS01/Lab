package me.srin.assignment_1;

import static java.lang.System.out;

public class Q1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            out.println("No args provided!");
            return;
        }
        for (int i = args.length - 1; i >= 0; i--) {
            out.printf("%s ", args[i]);
        }
        out.println();
    }
}
