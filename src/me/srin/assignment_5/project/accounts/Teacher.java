package me.srin.assignment_5.project.accounts;

import me.srin.assignment_5.project.Question;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.*;

public class Teacher extends Account {
    private static final String commandsHelp =
            "+-----------------------------------------------------------------------------+\n" +
            "|  Commands                                                                   |\n" +
            "+-----------------------------------------------------------------------------+\n" +
            "|  help - print this help message                                             |\n" +
            "|  add - add a new question                                                   |\n" +
            "|  remove [question number] - remove a question                               |\n" +
            "|  edit [question number] question|options|answer_key|all - edit a question   |\n" +
            "|  list - list all questions                                                  |\n" +
            "|  exit - exit the program                                                    |\n" +
            "+-----------------------------------------------------------------------------+\n";
    private static final Pattern REMOVE_PATTERN = Pattern.compile("^remove\\s+(\\d+)$");
    private static final Pattern EDIT_PATTERN = Pattern.compile("^edit\\s+(\\d+) (question|options|answer_key|all)$");

    public static void login() throws InterruptedException {
        Thread.sleep(500);
        out.println("logging in as teacher...");
        Thread.sleep(1000);
        out.println("use the following commands to edit or enter new questions");
        out.println(commandsHelp);
        executeCommands();
    }
    private static void executeCommands() {
        while (true) {
            out.print("--> ");
            String command = sc.nextLine();
            if (command.equals("help")) {
                out.println(commandsHelp);
            } else if (command.equals("add")) {
                QUESTIONS.add(Question.generate());
            } else if (command.equals("list")) {
                for (int i = 0; i < QUESTIONS.size(); i++) {
                    Question question = QUESTIONS.get(i);
                    question.printQuestionString(i + 1);
                    Question.Option option = question.getOptions();
                    out.printf("\t[a] %s\n", option.getA());
                    out.printf("\t[b] %s\n", option.getB());
                    out.printf("\t[c] %s\n", option.getC());
                    out.printf("\t[d] %s\n", option.getD());
                    out.printf("\tanswer: %s\n", question.getAnswerKey());
                }
            } else if (command.equals("exit")) {
                exit();
                break;
            } else if (command.matches(REMOVE_PATTERN.pattern())) {
                Matcher matcher = REMOVE_PATTERN.matcher(command);
                if (matcher.find()) {
                    int index = Integer.parseInt(matcher.group(1)) - 1;
                    if (index >= 0 && index < QUESTIONS.size()) {
                        QUESTIONS.remove(index);
                        out.println("Removed question " + (index + 1));
                    } else {
                        out.println("Invalid index.");
                    }
                }
            } else if (command.matches(EDIT_PATTERN.pattern())) {
                Matcher matcher = EDIT_PATTERN.matcher(command);
                if (matcher.find()) {
                    int index = Integer.parseInt(matcher.group(1)) - 1;
                    if (index >= 0 && index < QUESTIONS.size()) {
                        String editOption = matcher.group(2);
                        Question fetchedQuestion = QUESTIONS.get(index);
                        switch (editOption) {
                            case "question": fetchedQuestion.setQuestion(Question.createNewQuestion()); break;
                            case "options": fetchedQuestion.setOptions(Question.createNewOptions()); break;
                            case "answer_key": fetchedQuestion.setAnswerKey(Question.createNewAnswerKey()); break;
                            case "all":
                                fetchedQuestion.setQuestion(Question.createNewQuestion());
                                fetchedQuestion.setOptions(Question.createNewOptions());
                                fetchedQuestion.setAnswerKey(Question.createNewAnswerKey());
                        }
                        QUESTIONS.set(index, fetchedQuestion);
                    } else {
                        out.println("Invalid index.");
                    }
                }
            } else {
                out.println("Invalid command.");
            }
        }
    }
    protected static void exit() {
        try(Writer w = new FileWriter("questionPaper.json")) {
            w.append("{\n");
            for (int i = 0; i < QUESTIONS.size(); i++) {
                Question question = QUESTIONS.get(i);
                if (i == QUESTIONS.size() - 1) {
                    w.append(String.format("\t\"%d\": ", i + 1)).append(question.toString()).append("\n}");
                    continue;
                }
                w.append(String.format("\t\"%d\": ", i + 1)).append(question.toString()).append(",\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}