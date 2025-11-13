package com.demo.racecondition;

public class Account {
    private double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // try commenting 'synchronized' and re-running to see race condition
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
            balance -= amount;
            System.out.println("Remaining balance: " + balance);
        } else {
            System.out.println("Insufficient balance for " + Thread.currentThread().getName());
        }
    }
}
