package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Write a java program to implement the following operations: (take user input and use switch case) - <br>
 * <ul>
 *     <li>String reverse</li>
 *     <li>substring</li>
 *     <li>calculate string length</li>
 *     <li>and fetch character at 5</li>
 *     <li>search string using index of</li>
 * </ul>*/
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.println("select an option: ");
        out.println("\t1. String reverse");
        out.println("\t2. substring");
        out.println("\t3. calculate string length");
        out.println("\t4. fetch character at 5");
        out.println("\t5. search string using index of");
        out.println("\t6. enter a string");
        out.println("\t7. exit");
        char ch = '6';
        String str = null;
        while (ch != '7') {
            switch (ch) {
                case '1': {
                    printReverse(str);
                } break;
                case '2': {
                    out.print("enter a range: ");
                    String[] range = sc.nextLine().split(" ");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    if (start < 0 || end > str.length()) {
                        out.println("invalid range");
                    } else out.println(str.substring(start, end));
                } break;
                case '3': {
                    out.printf("length of string: %d\n", str.length());
                } break;
                case '4': {
                    int length = str.length();
                    if (length < 5) {
                        out.println("string length is less than 5");
                    } else out.println(str.charAt(length - 5));
                } break;
                case '5': {
                    out.print("enter a character or string to search: ");
                    String search = sc.nextLine();
                    out.printf("index of %s is %d\n", search, str.indexOf(search));
                } break;
                case '6': {
                    out.print("Enter a string: ");
                    str = sc.nextLine();
                } break;
                default: {
                    out.println("invalid option");
                } break;
            }
            out.print("--> ");
            ch = sc.nextLine().charAt(0);
        }
    }
    static void printReverse(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            out.print(str.charAt(i));
        } out.println();
    }
}
