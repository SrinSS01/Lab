package me.srin.assignment_5;

import java.util.Scanner;

import static java.lang.System.*;

public final class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(in);
        out.print("Enter name of the manager: ");
        String name = sc.nextLine();
        out.print("Enter salary of the manager: ");
        float salary = Float.parseFloat(sc.nextLine());
        Employee manager = new Manager(name, salary);
        out.print("Enter name of the clerk: ");
        name = sc.nextLine();
        out.print("Enter salary of the clerk: ");
        salary = Float.parseFloat(sc.nextLine());
        Employee clerk = new Clerk(name, salary);
        manager.display();
        clerk.display();
    }
    static abstract class Employee {
        protected final String name;
        protected final float salary, tax;
        public Employee(String name, float salary, float tax) {
            this.name = name;
            this.salary = salary;
            this.tax = tax;
        }
        public abstract float getNetSalary();
        public abstract void display();
        @Override
        public String toString() {
            return String.format("Employee { name: %s, salary: %.2f, net salary: %.2f }", name, salary, getNetSalary());
        }
    }
    static class Clerk extends Employee {
        public Clerk(String name, float salary) {
            super(name, salary, 15);
        }
        @Override
        public float getNetSalary() {
            return salary - (tax / 100) * salary;
        }
        @Override
        public void display() {
            out.println(this);
        }

        @Override
        public String toString() {
            return String.format("Clerk { name: %s, salary: %.2f, net salary: %.2f }", name, salary, getNetSalary());
        }
    }
    static class Manager extends Employee {
        public Manager(String name, float salary) {
            super(name, salary, 25);
        }
        @Override
        public float getNetSalary() {
            return salary - (tax / 100) * salary;
        }
        @Override
        public void display() {
            out.println(this);
        }
        @Override
        public String toString() {
            return String.format("Manager { name: %s, salary: %.2f, net salary: %.2f }", name, salary, getNetSalary());
        }
    }
}