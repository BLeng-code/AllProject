import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Pool { // 新建线程池类

    LinkedList<Runnable> runnableList = new LinkedList<Runnable>(); // 任务队列
    ArrayList<Thread> threadList = new ArrayList<Thread>(); // 线程池
    private int initSize; // 线程池初始大小
    private int coreSize; // 线程池核心大小
    private int maxSize; // 线程池最大大小
    private volatile boolean running = true; // 线程执行状态，默认执行
    private int active; // 线程活跃数，决定是否动态添加线程

    public Pool(int init, int core, int max) {
        // 初始化线程池
        this.initSize = init;
        this.maxSize = max;
        this.coreSize = core;
        synchronized (threadList) {
            for (int i = 0; i < initSize; i++) {
                Thread thread = new Thread(new MyRunnable());
                thread.start();
                threadList.add(thread);
            }
        }
    }

    public void execute(Runnable task) throws Exception {
        // 提交任务到线程池
        synchronized (runnableList) {
            if (runnableList.size() >= active) {
                // 如果任务数大于活跃线程数，决定是否需要动态增加新的线程
                if (threadList.size() >= maxSize) {
                    throw new Exception("线程池受不了了");
                } else if (threadList.size() <= coreSize) {
                    // 线程数小于核心线程数，则增加
                    System.out.println(Thread.currentThread().getName() + "  线程扩容到核心线程数");
                    for (int i = threadList.size(); i < coreSize; i++) {
                        Thread thread = new Thread(new MyRunnable());
                        thread.start();
                        threadList.add(thread);
                    }
                } else {
                    // 线程数小于最大线程数，则增加
                    System.out.println(Thread.currentThread().getName() + "  线程扩容到最大线程数");
                    for (int i = threadList.size(); i < maxSize; i++) {
                        Thread thread = new Thread(new MyRunnable());
                        thread.start();
                        threadList.add(thread);
                    }
                }
            }
            runnableList.add(task);
            runnableList.notifyAll();
        }
    }

    public void shutDown() {
        synchronized (runnableList) {
            running = false;
            active = 0;
            runnableList.notifyAll();
        }
    }

    public int getActive(){
        return active;
    }

    class MyRunnable implements Runnable { // 用于执行任务的runnable
        @Override
        public void run() {
            Runnable runnable = null;
            while (running) {
                active++; // 活跃数加一
                synchronized (runnableList) {
                    while (runnableList.isEmpty() && running) { // 如果任务队列为空，且线程在执行。则等待
                        try {
                            System.out.println(Thread.currentThread().getName() + "  进入等待");
                            runnableList.wait();
                        } catch (Exception e) {

                        }
                    }
                    synchronized (runnableList) {
                        if (runnableList.size() > 0) {
                            runnable = runnableList.removeFirst(); // 获取队列中的第一个任务
                        }
                    }
                    runnableList.notifyAll();
                }
                if (runnable != null) {
                    runnable.run(); // 执行任务
                }
                active--; // 活跃数减一
            }
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool(5, 10, 20);
        try {
            for (int i = 0; i < 21; i++) {
                final int temp = i;
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName() + "执行任务" + temp + "开始");
                        try {
                            TimeUnit.SECONDS.sleep(5);
                        } catch (Exception e) {
                            //TODO: handle exception
                        }
                        System.out.println(Thread.currentThread().getName() + "执行任务" + temp + "完毕");
                    }
                });
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "获取线程活跃数 "+ pool.getActive());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}