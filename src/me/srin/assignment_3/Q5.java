package me.srin.assignment_3;

import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Q5 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(in);
        out.print("Enter salary of employee: ");
        float salary = sc.nextFloat();
        out.print("Enter grade of employee: ");
        char grade = (char) in.read();
        Employee e = new Employee(salary, grade);
        out.print("Enter tax: ");
        float tax = sc.nextFloat();
        out.printf("The employee details are: %s\nand net salary: %.2f\n", e, e.netSalary(tax));
    }
    static class Employee {
        float salary;
        char grade;
        Employee(float salary, char grade) {
            this.salary = salary;
            this.grade = grade;
        }
        float netSalary(float tax) {
            return salary - tax;
        }

        public char grade() {
            return grade;
        }

        @Override
        public String toString() {
            return "{ salary: " + salary +", grade: " + grade() + " }";
        }
    }
}
