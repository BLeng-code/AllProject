import sun.awt.Mutex;

class Synchronize {
    public static void main(String[] args) {
        int MAX = 50;
        Object read = new Mutex();
        Object write = new Mutex();
        Runnable runnable = new Runnable() {
            int i = 1;
            @Override
            public void run() {
                while (true) {
                    if (i < MAX) {
                        synchronized (write) {
                            System.out.println(Thread.currentThread().getName() + "写数据，等待锁");
                            synchronized(read){
                                System.out.println(Thread.currentThread().getName() + "读数据");
                            }
                            System.out.println(i);
                            i++;
                        }
                    }
                }
            }
        };

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}