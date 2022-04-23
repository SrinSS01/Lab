package me.srin.assignment_5;

import java.util.Scanner;

import static java.lang.System.*;

public final class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the length: ");
        float len = sc.nextFloat();
        out.print("Enter the breadth: ");
        float breadth = sc.nextFloat();
        out.print("Enter the height: ");
        float height = sc.nextFloat();
        Box box = new Box(len, breadth, height);
        out.println("Volume of the box is: " + box.volume());
    }
    static class Box {
        private final float length, breadth, height;
        public Box(float length, float breadth, float height) {
            this.length = length;
            this.breadth = breadth;
            this.height = height;
        }
        public float volume() {
            return length * breadth * height;
        }
    }
}
