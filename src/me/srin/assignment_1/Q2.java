package me.srin.assignment_1;

import static java.lang.System.out;

public class Q2 {
    public static void main(String[] args) {
        if (args.length == 0) {
            out.println("No args provided!");
            return;
        }
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        out.printf("addition = %d\n", a + b);
        out.printf("subtraction = %d\n", a - b);
        out.printf("multiplication = %d\n", a * b);
        out.printf("division = %f\n", a / (b * 1.0f));
    }
}
