package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Write a Java program to trim any leading or trailing whitespace from a given string.*/
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a string: ");
        String str = sc.nextLine();
        out.printf("The string before trimming: \"%s\" and it's length is: %d\n", str, str.length());
        String trimmedStr = str.trim();
        out.printf("The string after trimming: \"%s\" and it's length is: %d\n", trimmedStr, trimmedStr.length());
    }
}
