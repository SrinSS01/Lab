package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Write a java program to concatenate two string using string and string buffer.
 */
public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the first string: ");
        String first = sc.nextLine();
        out.print("Enter the second string: ");
        String second = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        sb.append(first);
        sb.append(second);
        out.println("The concatenated string is: " + sb);
    }
}
