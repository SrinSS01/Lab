package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**Write a Java program to divide a string in n equal parts*/
public class Q7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the string: ");
        String str = sc.nextLine();
        out.print("Enter the number of parts: ");
        int n = sc.nextInt();
        int length = str.length();
        int substringIndex = length / n;
        if (n > length) {
            out.println("Number of parts cannot be greater than the length of the string");
        } else if (length % n != 0) {
            out.println("String cannot be divided in " + n + " equal parts");
        } else for (int i = 0; i < length;) {
            out.printf("\"%s\"\n", str.substring(i, i + substringIndex));
            i += substringIndex;
        }
    }
}
