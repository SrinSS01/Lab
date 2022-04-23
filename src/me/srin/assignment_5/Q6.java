package me.srin.assignment_5;

public final class Q6 {
    public static void main(String[] args) {
        Thread hello = new Thread(() -> System.out.println("HELLO"), "Hello");
        Thread hi = new Thread(() -> System.out.println("HI"), "hi");
        hello.start();
        hi.start();
    }
}
