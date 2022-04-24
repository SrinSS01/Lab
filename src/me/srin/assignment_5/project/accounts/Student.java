package me.srin.assignment_5.project.accounts;

import me.srin.assignment_5.project.Question;

import static java.lang.System.out;

public class Student extends Account {
    private static final String commandsHelp =
                    "+--------------------------------------------------------------------------------------+\n" +
                    "|  Commands:                                                                           |\n" +
                    "+--------------------------------------------------------------------------------------+\n" +
                    "|  help   - display this help message                                                  |\n" +
                    "|  exit   - exit the program                                                           |\n" +
                    "|  start  - start the exam                                                             |\n" +
                    "|  submit - submit the exam                                                            |\n" +
                    "|  show <optional: [question number]> - shows the next question if no number specified |\n" +
                    "|                                       or else shows question of the given number     |\n" +
                    "|  skip <optional: [question number]> - skip to the next question                      |\n" +
                    "|                                       or the specified question number               |\n" +
                    "|  result - show the result                                                            |\n"+
                    "+--------------------------------------------------------------------------------------+\n";
    private static int totalMarks = 0, numberOfRightAnswers = 0, numberOfWrongAnswers = 0, notAnswered = QUESTIONS.size();
    public static void login() throws InterruptedException {
        if (QUESTIONS.size() == 0) {
            out.println("no questions found, logging out...");
            Thread.sleep(1000);
            return;
        }
        Thread.sleep(500);
        out.println("logging in as student...");
        Thread.sleep(1000);
        out.println("use the following commands to edit or enter new questions");
        out.println(commandsHelp);
        executeCommands();
    }

    private static void executeCommands() throws InterruptedException {
        while (true) {
            out.print("--> ");
            String command = sc.nextLine();
            switch (command) {
                case "help": out.println(commandsHelp); break;
                case "start": startExam(); break;
                case "result": showResult(); break;
                case "exit": return;
                default: out.println("invalid command");
            }
        }
    }

    private static void showResult() {
        out.println("+---------------------------------+");
        out.printf("|  total marks     |%12s  |\n", totalMarks);
        out.println("+---------------------------------+");
        out.printf("|  right answers   |%12s  |\n", numberOfRightAnswers);
        out.printf("|  wrong answers   |%12s  |\n", numberOfWrongAnswers);
        out.printf("|  not answered    |%12s  |\n", notAnswered);
        out.println("+---------------------------------+");
    }

    private static boolean submitExam() {
        out.println("Are you sure you want to submit the exam? (y/n)");
        String answer = sc.nextLine().trim();
        while (true) {
            if (answer.matches("[yY]")) {
                out.println("Exam submitted");
                return true;
            }
            else if (answer.matches("[nN]")) return false;
            else {
                out.println("Please enter y or n");
            }
        }
    }

    private static void startExam() throws InterruptedException {
        out.println("Starting exam...");
        Thread.sleep(1000);
        int numberOfQuestions = QUESTIONS.size();
        for (int i = 0; i < numberOfQuestions;) {
            Question question = QUESTIONS.get(i);
            question.printQuestionString(i + 1);
            Question.Option option = question.getOptions();
            out.printf("\t%s [a] %s\n", option.isSelected('a') ? "*" : " ", option.getA());
            out.printf("\t%s [b] %s\n", option.isSelected('b') ? "*" : " ", option.getB());
            out.printf("\t%s [c] %s\n", option.isSelected('c') ? "*" : " ", option.getC());
            out.printf("\t%s [d] %s\n", option.isSelected('d') ? "*" : " ", option.getD());
            out.print("Select your answer (a/b/c/d) or skip to skip the question: ");
            String answer = sc.nextLine().trim().toLowerCase();
            while (!answer.matches("[abcd]") && !answer.equals("skip")) {
                out.println("invalid option!");
                out.print("Select your answer (a/b/c/d) or skip to skip the question: : ");
                answer = sc.nextLine().trim().toLowerCase();
            }
            if (answer.matches("[abcd]")) {
                option.select(answer.charAt(0));
                if (answer.equals(question.getAnswerKey())) {
                    totalMarks += 4;
                    numberOfRightAnswers++;
                } else {
                    numberOfWrongAnswers++;
                    totalMarks -= 1;
                }
                if (option.anySelected()) notAnswered--;
            } else if (answer.equals("skip")) {
                out.println("skipping question...");
                i++; continue;
            }
            while (true) {
                out.print("> ");
                String command = sc.nextLine().trim();
                if (command.equals("help")) out.println(commandsHelp);
                else if (command.equals("submit") && submitExam()) return;
                else if (command.matches("show \\d+")) {
                    i = Integer.parseInt(command.substring(5)) - 1;
                    if (i > numberOfQuestions - 1 || i < 0) {
                        out.println("Question number out of range");
                    }
                } else if (command.equals("show")) {
                    i++;
                } else {
                    out.println("invalid command");
                    continue;
                }
                break;
            }
        }
        out.println("Exam finished");
        out.println("Submitting exam...");
        Thread.sleep(1000);
        showResult();
    }
}