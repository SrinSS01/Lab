package me.srin.assignment_5.project;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.in;
import static java.lang.System.out;

public class Question {
    private static final Scanner sc = new Scanner(in);
    private String question;
    private String answer_key;
    private Option options;
    private static final Pattern QUESTION_PATTERN = Pattern.compile("\\{\"question\": \"(?<q>.+)\", \"options\": \\[\"(?<a>.+)\", \"(?<b>.+)\", \"(?<c>.+)\", \"(?<d>.+)\"], \"answer_key\": \"(?<ans>[abcd])\"}");

    private Question(String question, Option options, String answer_key) {
        this.question = question;
        this.answer_key = answer_key;
        this.options = options;
    }
    public static Question parse(String line) throws IllegalArgumentException {
        Matcher m = QUESTION_PATTERN.matcher(line);
        if (m.find()) {
            return new Question(
                    m.group("q"),
                    new Option(m.group("a"), m.group("b"), m.group("c"), m.group("d")), m.group("ans")
            );
        } else {
            throw new IllegalArgumentException("Invalid question format");
        }
    }
    public static Question generate() {
        return new Question(createNewQuestion(), createNewOptions(), createNewAnswerKey());
    }
    public static String createNewAnswerKey() {
        out.print("Enter the answer (a, b, d or d): ");
        String answer = sc.nextLine().toLowerCase();
        while (!answer.matches("[abcd]")) {
            out.println("Invalid option given. Please enter a valid answer.");
            answer = sc.nextLine().toLowerCase();
        }
        return answer;
    }
    public static Option createNewOptions() {
        out.print("Option A: ");
        String a = sc.nextLine().toLowerCase();
        out.print("Option B: ");
        String b = sc.nextLine().toLowerCase();
        out.print("Option C: ");
        String c = sc.nextLine().toLowerCase();
        out.print("Option D: ");
        String d = sc.nextLine().toLowerCase();
        return new Option(a, b, c, d);
    }
    public static String createNewQuestion() {
        out.println("Enter question (type /end to stop):");
        StringBuilder question = new StringBuilder();
        while (true) {
            out.print("> ");
            String line = sc.nextLine().trim();
            if (line.equals("/end")) {
                break;
            }
            question.append(line).append("\n");
        }
        return question.toString().trim();
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswerKey(String answer_key) {
        this.answer_key = answer_key;
    }
    public Option getOptions() {
        return options;
    }

    public void setOptions(Option options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return String.format(
            "{\"question\": \"%s\", %s, \"answer_key\": \"%s\"}",
            question.trim(), options, answer_key
        );
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswerKey() {
        return answer_key;
    }

    public static class Option {
        private final String option_a;
        private final String option_b;
        private final String option_c;
        private final String option_d;
        char selected = 0;
        private Option(String option_a, String option_b, String option_c, String option_d) {
            this.option_a = option_a;
            this.option_b = option_b;
            this.option_c = option_c;
            this.option_d = option_d;
        }

        public String getA() {
            return option_a;
        }

        public String getB() {
            return option_b;
        }

        public String getC() {
            return option_c;
        }

        public String getD() {
            return option_d;
        }

        @Override
        public String toString() {
            return String.format(
                "\"options\": [\"%s\", \"%s\", \"%s\", \"%s\"]",
                option_a, option_b, option_c, option_d
            );
        }
        public boolean isSelected(char option) {
            return option == selected;
        }

        public void select(char answer) {
            selected = answer;
        }

        public boolean anySelected() {
            return selected != 0;
        }
    }
}