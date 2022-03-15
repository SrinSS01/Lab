package me.srin.assignment_2;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter width: ");
        int width = sc.nextInt();
        out.print("Enter height: ");
        int height = sc.nextInt();
        Area area = new Area(width, height);
        out.printf("Area of the rectangle is %d\n", area.returnArea());
    }
    static class Area {
        private final int width;
        private final int height;
        public Area(int w, int h) {
            width = w;
            height = h;
        }
        public int returnArea() {
            return width * height;
        }
    }
}
