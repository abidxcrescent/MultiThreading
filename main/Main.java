package main;

import usingInterface.ThreadInterface;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main started " + Thread.currentThread().getName());
        ThreadInterface threadInterface = new ThreadInterface();
        Thread thread = new Thread(threadInterface);
        thread.start();
        System.out.println("Main ended " + Thread.currentThread().getName());
    }
}
