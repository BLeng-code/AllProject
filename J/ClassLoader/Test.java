
class Test {
    public static void main(String[] args) {
        final ClassLoader classLoader = new MyClassLoader();
        try {

            Object obj = classLoader.loadClass("Hello").newInstance();
            System.out.println(obj.getClass());
            System.out.println(obj.getClass().getClassLoader());

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                ClassLoader classLoader2 = Thread.currentThread().getContextClassLoader();
                try {
                    Class obj = classLoader.loadClass("Hello");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    Class objClass = Class.forName("Hello");
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Hello hello = new Hello();
                System.out.println(hello.getClass());
                System.out.println(hello.getClass().getClassLoader());
            }
        });
        thread.setContextClassLoader(classLoader);
        thread.start();
    }
}