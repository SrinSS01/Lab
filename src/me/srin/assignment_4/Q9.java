package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**Write a java program Java Reverse String Array Example.*/
public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the number of strings: ");
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for (int i = n - 1; i >= 0; i--) {
            out.print(str[i] + " ");
        }
    }
}
