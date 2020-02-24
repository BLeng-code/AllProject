
class Test {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("../");
        try {
            Class clazz = myClassLoader.loadClass("B");
            Object instance = clazz.newInstance();
            System.out.println(clazz.getClassLoader());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}