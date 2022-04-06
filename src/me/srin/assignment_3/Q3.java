package me.srin.assignment_3;

import static java.lang.System.*;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter area of square: ");
        double area = sc.nextDouble();
        out.printf("Perimeter of square: %.4f\n", 4 * (Math.sqrt(area)));
    }
}
