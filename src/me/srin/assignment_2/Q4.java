package me.srin.assignment_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter the first distance in d' d\" format: ");
        String first = sc.nextLine();
        Distance firstDistance = new Distance(first);
        out.print("Enter the second distance in d' d\" format: ");
        String second = sc.nextLine();
        Distance secondDistance = new Distance(second);
        out.printf("The sum of the two distances is: %s\n", AddDistance.addDistance(firstDistance, secondDistance));
    }
    static class Distance {
        private final int feet;
        private final int inches;
        public Distance(int feet, int inches) {
            feet += inches / 12;
            inches %= 12;
            this.feet = feet;
            this.inches = inches;
        }
        public Distance(String distance) throws IllegalArgumentException {
            Pattern pattern = Pattern.compile("^(\\d+)'\\s*(\\d+)\"$");
            Matcher matcher = pattern.matcher(distance);
            if (matcher.matches()) {
                int feet = Integer.parseInt(matcher.group(1));
                int inches = Integer.parseInt(matcher.group(2));
                feet += inches / 12;
                inches %= 12;
                this.feet = feet;
                this.inches = inches;
            } else throw new IllegalArgumentException("Invalid distance: " + distance);
        }
        public Distance add(Distance that) {
            return new Distance(feet + that.feet, inches + that.inches);
        }
        @Override
        public String toString() {
            return feet + "' " + inches + "\"";
        }
    }
    static class AddDistance {
        public static Distance addDistance(Distance d1, Distance d2) {
            return d1.add(d2);
        }
    }
}
