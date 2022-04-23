package me.srin.assignment_5;

import java.util.Scanner;

import static java.lang.System.*;

public final class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter name of the politician: ");
        String name = sc.nextLine();
        out.print("Enter salary of the politician: ");
        float salary = Float.parseFloat(sc.nextLine());
        Person politician = new Politician(name, salary);
        out.print("Enter name of the Sportsman: ");
        name = sc.nextLine();
        out.print("Enter salary of the Sportsman: ");
        salary = sc.nextFloat();
        Person sportsman = new Sportsman(name, salary);
        politician.display();
        sportsman.display();
    }
    static abstract class Person {
        protected final String name;
        protected final float salary;
        public Person(String name, float salary) {
            this.name = name;
            this.salary = salary;
        }
        public float getSalary() {
            return salary;
        }
        public void display() {
            out.println(this);
        }
        @Override
        public String toString() {
            return String.format("Person { name: %s, salary: %.2f }", name, salary);
        }
    }
    static class Politician extends Person {
        public Politician(String name, float salary) {
            super(name, salary);
        }
        @Override
        public String toString() {
            return String.format("Politician { name: %s, salary: %.2f }", name, getSalary());
        }
    }
    static class Sportsman extends Person {
        public Sportsman(String name, float salary) {
            super(name, salary);
        }
        @Override
        public String toString() {
            return String.format("Sportsman { name: %s, salary: %.2f }", name, getSalary());
        }
    }
}