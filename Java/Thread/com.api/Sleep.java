import java.util.concurrent.TimeUnit;

/**
 * sleep方法可被中断，会阻塞当前线程制定时常
 * TimeUnit可以灵活设置线程阻塞时间，比如3天4小时5分钟6秒200毫秒57微秒100纳秒
 */
class Sleep {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    // TimeUnit.SECONDS.sleep(3);
                    System.out.println("abc");
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        });
        thread.start();
        
    }
}