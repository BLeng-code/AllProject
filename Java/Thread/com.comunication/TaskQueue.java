import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import sun.awt.Mutex;

class TaskQueue {
    int MAX = 10;
    LinkedList<String> list = new LinkedList<String>();
    Object mutex = new Mutex();

    public void add(String task) {
        synchronized (mutex) {
            try {
                while (list.size() >= MAX) {
                    System.out.println("队列满了");
                    mutex.wait();
                }
                System.out.println("添加任务" + task);
                list.add(task);
                mutex.notifyAll();
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

    public void execute() {
        synchronized (mutex) {
            try {
                while (list.size() == 0) {
                    System.out.println("队列空了");
                    mutex.wait();
                }
                String task = list.removeFirst();
                System.out.println(Thread.currentThread().getName() + "执行任务");
                TimeUnit.SECONDS.sleep(5);
                mutex.notifyAll();
                System.out.println("执行完 " + task);

            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }
}