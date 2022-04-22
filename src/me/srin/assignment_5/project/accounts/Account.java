package me.srin.assignment_5.project.accounts;

import me.srin.assignment_5.project.Question;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public abstract class Account {
    protected static final Scanner sc = new Scanner(in);
    protected static final ArrayList<Question> QUESTIONS = new ArrayList<>();
    static {
        File questionPaper = new File("questionPaper.json");
        if (!questionPaper.exists()) {
            out.println("Question paper has not been set yet.");
        } else {
            try (Scanner sc = new Scanner(questionPaper)) {
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    if (line.matches("[{}]")) continue;
                    QUESTIONS.add(Question.parse(line));
                }
            } catch (FileNotFoundException | IllegalArgumentException e) {
                out.println("Error reading question paper.");
            }
        }
    }
}
