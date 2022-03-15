package me.srin.assignment_1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a limit for the fibonacci series: ");
        long limit = sc.nextLong();
        Fibonacci.printSeries(limit);
        sc.close();
    }
    static class Fibonacci {
        public static void printSeries(long limit) {
            out.print("0, 1");
            long a = 0;
            long b = 1;
            while ((b = a + b) <= limit) {
                out.printf(", %d", b);
                a = b - a;
            }
        }
    }
}
