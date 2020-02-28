public class Test {

    ThreadLocal<Integer> iLocal = new ThreadLocal<>();
    int i;

    public static void main(String[] args) {
        Test test = new Test();
        Runnable run1 = new Runnable() {

            @Override
            public void run() {
                test.iLocal.set(2);
                test.i = 20;
                System.out.println(Thread.currentThread().getName() + " 设置 iLocal = " + test.iLocal.get());
                System.out.println(Thread.currentThread().getName() + " 设置 i = " + test.i);
            
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 修改后 iLocal = " + test.iLocal.get());
                System.out.println(Thread.currentThread().getName() + " 修改后 i = " + test.i);
            }
        };
        Thread th1 = new Thread(run1, "线程1");

        Runnable run2 = new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                test.iLocal.set(3);
                test.i = 30;
                System.out.println(Thread.currentThread().getName() + " 设置 iLocal = " + test.iLocal.get());
                System.out.println(Thread.currentThread().getName() + " 设置 i = " + test.i);
            }
        };
        Thread th2 = new Thread(run2, "线程2");
        th1.start();
        th2.start();
    }
}