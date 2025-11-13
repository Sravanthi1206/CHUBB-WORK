package com.demo.deadlock;

public class DeadlockDemo {
    private final Object room = new Object();
    private final Object payment = new Object();

    public void simulateDeadlock() {
        Thread t1 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User1 locked Room");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (payment) {
                    System.out.println("User1 locked Payment");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (payment) {
                System.out.println("User2 locked Payment");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (room) {
                    System.out.println("User2 locked Room");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadlockDemo().simulateDeadlock();
    }
}
