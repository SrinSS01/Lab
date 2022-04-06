package me.srin.assignment_4;

import java.util.Scanner;

import static java.lang.System.*;

/**Write a java program to convert int Array To String Example using string buffer.*/
public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        out.print("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        StringBuffer sb = new StringBuffer();
        for (int element : arr) {
            sb.append(element);
        }
        out.println("The array in string format is: " + sb);
    }
}
