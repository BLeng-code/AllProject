public class A {
    private static Object instance;

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("../");
        Thread.currentThread().setContextClassLoader(myClassLoader);
        Class clazz = null;
        try {
            clazz = myClassLoader.loadClass("B");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Object instance = clazz.newInstance();
            System.out.println(instance.getClass().getClassLoader());
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}