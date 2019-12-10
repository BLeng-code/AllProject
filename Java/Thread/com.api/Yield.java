/**
 * yield主动放弃cpu使用权
 * 
 */
class Yield {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("子线程正在执行");
                System.out.println("子线程yield");
                Thread.yield();
                System.out.println("子线程正在执行");
            }
        });
        thread.start();
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println("主线程正在执行");
        System.out.println(Thread.currentThread().getName());
    }
}