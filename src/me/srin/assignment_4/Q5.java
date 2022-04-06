package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Write a Java program to get the last index of a string within a string.
 */
public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a string: ");
        String str = sc.nextLine();
        out.print("Enter another string: ");
        String stringToFind = sc.nextLine();
        int index = str.lastIndexOf(stringToFind);
        if (index == -1) {
            out.println("String not found");
        } else {
            out.printf("Last index of \"%s\" in \"%s\" is %d\n", stringToFind, str, index);
        }
    }
}
