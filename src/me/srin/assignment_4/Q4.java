package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;
/**
 * Write a Java program to check whether two String objects contain the same data.*/
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the first string: ");
        String firstString = sc.nextLine();
        out.print("Enter the second string: ");
        String secondString = sc.nextLine();
        if (firstString.equals(secondString)) {
            out.println("The two strings are equal.");
        } else {
            out.println("The two strings are not equal.");
        }
    }
}
