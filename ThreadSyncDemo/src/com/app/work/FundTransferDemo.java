package com.app.work;

// File: FundTransferDemo.java
class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    // synchronized prevents race condition
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing " + amount);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw " + amount + " but insufficient balance.");
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class FundTransferDemo {
    public static void main(String[] args) throws InterruptedException {
        Account acc = new Account(1000);

        // Threads created using lambda (no Runnable class)
        Thread t1 = new Thread(() -> acc.withdraw(700), "User-1");
        Thread t2 = new Thread(() -> acc.withdraw(700), "User-2");

        // start both threads
        t1.start();
        t2.start();

        // wait for both threads to finish
        t1.join();
        t2.join();

        System.out.println("Final balance: " + acc.getBalance());
    }
}
