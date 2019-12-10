import java.util.concurrent.TimeUnit;

/**
 * wait和notify方法都是对象的，
 * 都必须放在锁住该对象的synchronized代码块或者方法中，否则报IllegalMonitorStateException
 * wait方法被notify且被cpu调度执行之后，会继续执行之后的代码
 * A.notify方法只能通知当前线程的A.wait方法，A.notifyAll方法可以通知所有线程的A.wait方法
 * wait方法可以被中断
 * wait方法不占用对象的锁，sleep方法占有对象的锁
 */
class WaitAndNotify {
    public static void main(String[] args) {
        String lock = "abc";
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    synchronized (lock) {
                        lock.wait(5000);
                        System.out.println("被通知，不用等了");
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                    System.out.println("被中断，不用等了");
                }

            }
        });
        thread.start();

        try {
            // TimeUnit.SECONDS.sleep(5);
            ;
            // System.out.println("通知，不用等了");
            // synchronized (lock) {
            //     lock.notify();
            // }
            // System.out.println("中断，不用等了");
            // thread.interrupt();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}