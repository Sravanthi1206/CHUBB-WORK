package com.demo.deadlock;

public class SafeBooking {
    private final Object room = new Object();
    private final Object payment = new Object();

    public void avoidDeadlock() {
        Thread t1 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User1 locked Room");
                synchronized (payment) {
                    System.out.println("User1 locked Payment");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (room) {
                System.out.println("User2 locked Room");
                synchronized (payment) {
                    System.out.println("User2 locked Payment");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new SafeBooking().avoidDeadlock();
    }
}
