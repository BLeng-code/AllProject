import java.util.concurrent.TimeUnit;

class Test {
    public static void main(String[] args) {
        Test test = new Test();
        final Test.A a =test.new A();
        Thread thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                a.say();
            }
        });
        thread.start();

        thread = new Thread(new Runnable(){
        
            @Override
            public void run() {
                a.eat();
            }
        });
        thread.start();
    }

    class A {
        public synchronized void say() {
            System.out.println("说话");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("说话完成");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        public synchronized void eat() {
            System.out.println("吃饭");
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("吃饭完成");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}