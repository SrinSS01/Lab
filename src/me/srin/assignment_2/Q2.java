package me.srin.assignment_2;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a string: ");
        String str = sc.nextLine();
        if (Palindrome.isPalindrome(str)) {
            out.println("The string is a palindrome.");
        } else {
            out.println("The string is not a palindrome.");
        }
    }
    static class Palindrome {
        public static boolean isPalindrome(String s) {
            int len = s.length();
            for (int i = 0; i < len / 2; i++) {
                if (s.charAt(i) != s.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
