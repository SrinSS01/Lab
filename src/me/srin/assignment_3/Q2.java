package me.srin.assignment_3;

import java.util.Scanner;
import static java.lang.System.*;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the radius of the cylinder base: ");
        double radius = sc.nextDouble();
        out.print("Enter the height of the cylinder: ");
        double height = sc.nextDouble();
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        out.printf("Surface area of a cylinder: %.4f", surfaceArea);
    }
}
