import java.util.concurrent.TimeUnit;

/**
 * a线程join b线程会导致b线程被阻塞直到a线程terminated或者到指定时间，如果指定时间之前a线程已经终止则b线程会继续执行
 */
class Join {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    System.out.println("1线程正在执行");
                    TimeUnit.SECONDS.sleep(15);
                    System.out.println("1线程执行完毕");
                } catch (Exception e) {
                    //TODO: handle exception
                    System.out.println("sleep 被中断");
                }
            }
        });
        thread1.start(); 
        // Thread thread2 = new Thread(new Runnable() {

        //     @Override
        //     public void run() {
        //         System.out.println("2线程正在执行");
        //         try {
        //             thread1.join(10 * 1000);
        //         } catch (Exception e) {
        //             // TODO: handle exception
        //             System.out.println("join 被中断");
        //         }
        //     }
        // });
        // thread2.start();
        
        try {
            System.out.println("主线程正在执行");
            thread1.join(10 * 1000);
            thread1.interrupt();
            System.out.println("主线程执行完毕");
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("sleep 被中断");
        }
    }
}