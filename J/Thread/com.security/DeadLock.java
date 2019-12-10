import java.util.concurrent.TimeUnit;

import sun.awt.Mutex;

class DeadLock {
    public static Object write = "abc";
    public static Object read = "abcd";

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("获取写锁");
                    synchronized (write) {
                        System.out.println("写数据");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("获取读锁");
                        synchronized (read) {
                            System.out.println("读数据");
                        }
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, "线程1");
        thread.start();
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("获取读锁");
                    synchronized (read) {
                        System.out.println("读数据");
                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("获取写锁");
                        synchronized (write) {
                            System.out.println("写数据");
                        }
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }

            }
        }, "线程2");
        thread.start();
    }
}