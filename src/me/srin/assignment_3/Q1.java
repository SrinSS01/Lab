package me.srin.assignment_3;

import static java.lang.System.out;

public class Q1 {
    public static void main(String... args) {
        fakeMain("1", "2", "3", "4", "5");
    }
    static void fakeMain(String... args) {
        int sumOfSquares = 0;
        int squareOfSum = 0;
        for (String arg : args) {
            int num = Integer.parseInt(arg);
            sumOfSquares += num * num;
            squareOfSum += num;
        }
        squareOfSum = squareOfSum * squareOfSum;
        out.printf("sum of squares: %d\n", sumOfSquares);
        out.printf("square of sums: %d\n", squareOfSum);
    }
}
