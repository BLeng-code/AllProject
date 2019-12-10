import java.util.concurrent.TimeUnit;

class Group {
    public static void main(String[] args) {
        ThreadGroup group1 = new ThreadGroup("group1");
        group1.setDaemon(true);
        Thread thread = new Thread(group1, new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println(
                            Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "正在工作");
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(
                            Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "被中断");
                }
            }
        }, "thread1");
        thread.start();
        try {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "正在工作");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "被中断");
        }
        System.out.println(group1.activeCount());
        group1.setMaxPriority(3);
        group1.interrupt();
        thread = new Thread(group1, new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println(
                            Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "正在工作");
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println(
                            Thread.currentThread().getName() + " " + Thread.currentThread().getPriority() + "被中断");
                }
            }
        }, "thread2");
        thread.start();

    }
}