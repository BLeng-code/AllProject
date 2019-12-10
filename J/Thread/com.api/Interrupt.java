import java.util.concurrent.TimeUnit;

/**
 * interrupt可以向线程中正在执行的可中断的阻塞方法发送中断信号，
 */
class Interrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                // try {
                //     TimeUnit.SECONDS.sleep(3);;
                // } catch (Exception e) {
                //     e.printStackTrace();
                // }
                boolean flag = true;
                try {
                    while(flag) {
                        System.out.println("子线程正在执行");
                        TimeUnit.MILLISECONDS.sleep(3);
                    }
                } catch (Exception e) {
                    flag = false;
                }
                
            }
        });
        thread.start();
        thread.interrupt();
    }
}