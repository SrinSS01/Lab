package me.srin.assignment_1;

import static java.lang.System.out;

public class Q5 {
    public static void main(String[] args) {
        if (args.length == 0) {
            out.println("No args provided!");
            return;
        }
        int number = Integer.parseInt(args[0]);
        int factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }
        out.printf("factorial of %d = %d\n", number, factorial);
    }
}
