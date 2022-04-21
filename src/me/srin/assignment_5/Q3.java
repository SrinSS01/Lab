package me.srin.assignment_5;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.System.*;

public final class Q3 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(in);
        LinkedList<Integer> list = new LinkedList<>();
        out.println("Enter elements (type /q or /quit to stop): ");
        while (true) try {
            out.print("--> ");
            String input = sc.nextLine();
            if (input.matches("/(q|quit)")) break;
            else {
                int element = Integer.parseInt(input);
                if (element < 0 ) throw new NegativeSizeException();
                else list.add(element);
            }
        } catch (NegativeSizeException | NumberFormatException e) { e.printStackTrace(); Thread.sleep(50); }
        out.print("The array is: ");
        out.println(list);
    }
    static class NegativeSizeException extends Exception {
        public NegativeSizeException() {
            super("cannot have negative values in an array");
        }
    }
}