class Handler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + "出现异常");
                e.printStackTrace();
            }
        });
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(1 / 0);
            }
        });
        thread1.start();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){
        
            @Override
            public void run() {
                System.out.println("虚拟机执行完毕");
            }
        }));
    }
}