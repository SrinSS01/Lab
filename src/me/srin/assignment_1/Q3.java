package me.srin.assignment_1;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q3 {
    static boolean isPrime(int begin, int n) {
        if (n == 0 || n == 1) return false;
        if (n == begin) return true;
        if (n % begin == 0) return false;
        return isPrime(begin + 1, n);
    }
    static boolean isPrime(int n) { return isPrime(2, n); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a number: ");
        int n = sc.nextInt();
        out.printf("%d is %s\n", n, isPrime(n)? "prime": "not prime");
    }
}
