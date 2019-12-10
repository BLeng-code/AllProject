import java.util.concurrent.TimeUnit;

/**
 * 实现一个自定义线程池 支持的功能初始化，运行任务，关闭线程池
 * 
 */
class Test {
    public static void main(String[] args) {
        Pool pool = new Pool(5, 10, 20);

        try {
            for (int i = 0; i < 1; i++) {
                final int temp = i;
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("任务" + temp + "开始执行");
                            TimeUnit.SECONDS.sleep(3);
                            System.out.println("任务" + temp + "完毕");
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                });
            }

            TimeUnit.SECONDS.sleep(30);
            pool.shutDown();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}