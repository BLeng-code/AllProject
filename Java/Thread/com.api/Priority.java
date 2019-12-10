/**
 * setPriority可以设置线程优先级，但是是否被调度由cpu决定，
 * 优先级只是参考作用，所以不能作为真正执行顺序
 */
class Priority {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("子线程正在执行" + Thread.currentThread().getPriority());
            }
        });
        thread.setPriority(9);
        thread.start();
        System.out.println("主线程正在执行" + Thread.currentThread().getPriority());
    }
}