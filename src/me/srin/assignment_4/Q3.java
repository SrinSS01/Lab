package me.srin.assignment_4;

/**
 * Write a java program to split the given string into words:
 * <div style="font-weight: bold;">“Hello, How are you.”</div>*/
public class Q3 {
    public static void main(String[] args) {
        String str = "Hello, How are you.";
        String[] words = str.split(" ");
        for (String word : words) {
            System.out.println(word);
        }
    }
}
