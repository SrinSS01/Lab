package me.srin.assignment_5;

import java.util.Scanner;

import static java.lang.System.*;

public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter charge amount: ");
        float charge = sc.nextFloat();
        out.printf("payback amount = %.2f\n", payBack(charge));
    }
    public static float payBack(float amount) {
        float payBackAmount = 0;
        if (amount <= 500) { payBackAmount += .25 * .01 * amount; }
        else {
            payBackAmount+= .25 * .01 * 500; amount -= 500;
            if (amount > 500 && amount <= 1500) { payBackAmount += .50 * .01 * amount; }
            else {
                payBackAmount += .50 * .01 * 1000; amount -= 1000;
                if (amount > 1500 && amount <= 2500) { payBackAmount += .75 * .01 * amount; }
                else {
                    payBackAmount += .50 * .01 * 1000; amount -= 1000;
                    if (amount > 2500) { payBackAmount += 1 * .01 * amount; }
                }
            }
        }
        return payBackAmount;
    }
}
