package me.srin.assignment_5;

import java.util.Scanner;
import static java.lang.System.*;

public final class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter a string to calculate frequency of each characters: ");
        String str = sc.nextLine();
        int[] freq = new int[256];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c > 255 || c == ' ') continue;
            freq[c]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            out.printf("%c: %d\n", (char)i, freq[i]);
        }
    }
}