package me.srin.assignment_3;

import java.util.Scanner;
import static java.lang.System.*;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter principal amount: ");
        double p = sc.nextDouble();
        out.print("Enter rate of interest: ");
        double r = sc.nextDouble();
        out.print("Enter number of years: ");
        int n = sc.nextInt();
        out.printf("Simple Interest: %.2f\n", (p * r * n) / 100);
    }
}
