package me.srin.assignment_5.project;

import me.srin.assignment_5.project.accounts.Student;
import me.srin.assignment_5.project.accounts.Teacher;

import java.util.Scanner;

import static java.lang.System.*;

public class Project {
    public static void main(String[] args) throws InterruptedException {
        out.println("Welcome to Srinjoy's MCQ Exam app!\nEach question has 4 options.\n+4 marks for correct answer.\n-1 marks for wrong answer.\n");
        try (Scanner sc = new Scanner(in)) {
            while (true) {
                out.print("Select account type (student/teacher) to login: ");
                String accountType = sc.nextLine();
                if (accountType.equals("student")) {
                    Student.login();
                    break;
                } else if (accountType.equals("teacher")) {
                    Teacher.login();
                    break;
                } else out.println("Invalid account type!");
            }
        }
    }
}
