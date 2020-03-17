import java.lang.reflect.Proxy;

public class Test {
    public static void main(final String[] args) {
        People people = new People();
        try {
            Shopping proxy = (Shopping) Proxy.newProxyInstance(people.getClass().getClassLoader(), new Class[] { Shopping.class },
                    new PeopleInvoker(people));
            proxy.shopping();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}