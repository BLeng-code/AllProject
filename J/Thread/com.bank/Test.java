package com.bank;

class Test {

    public static void main(String[] args) {
        System.out.println("abc");
        Runnable runnable = new Runnable() {

            private int MAX = 50;
            private int x = 0;

            @Override
            public void run() {
                while (x < MAX) {
                    System.out.println(Thread.currentThread().toString() + ++x);
                }
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

    }
}