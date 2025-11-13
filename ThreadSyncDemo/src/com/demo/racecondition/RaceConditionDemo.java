package com.demo.racecondition;

public class RaceConditionDemo {
    public static void main(String[] args) {
        Account account = new Account(1000);

        Thread t1 = new Thread(() -> account.withdraw(800), "User1");
        Thread t2 = new Thread(() -> account.withdraw(800), "User2");

        t1.start();
        t2.start();
    }
}
