import java.util.LinkedList;

/**
 * 初始化 执行任务 维护初始线程数，核心线程数，最大线程数
 */
class Pool {
    int init;
    int core;
    int max;
    LinkedList<Runnable> runnableList = new LinkedList<Runnable>();
    LinkedList<Thread> threadList = new LinkedList<>();
    volatile boolean running = true;

    public Pool(int init, int core, int max) {
        this.init = init;
        this.core = core;
        this.max = max;
        synchronized (runnableList) {
            for (int i = 0; i < init; i++) {
                Thread thread = new Thread(new MyThread());
                thread.start();
                threadList.add(thread);
            }
        }
    }

    public void execute(Runnable runnable) throws Exception {
        synchronized (runnableList) {
            int size = runnableList.size();
            if (size > init && size < max) {
                Thread thread = new Thread(new MyThread());
                thread.start();
                threadList.add(thread);
            }
            if (size > max) {
                throw new Exception("超过限制");
            } else {
                runnableList.add(runnable);
                runnableList.notifyAll();
            }

        }
    }

    class MyThread implements Runnable {
        @Override
        public void run() {
            while (running) {
                Runnable runnable = null;
                synchronized (runnableList) {
                    while (runnableList.isEmpty() && running) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "正在等待任务");
                            runnableList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (running) {
                        runnable = runnableList.removeFirst();
                    }
                }
                if (runnable != null) {
                    System.out.println(Thread.currentThread().getName() + "正在执行任务");
                    runnable.run();
                }
            }

        }
    }

    public void shutDown() {
        synchronized (runnableList) {
            running = false;
            runnableList.notifyAll();
        }
    }
}