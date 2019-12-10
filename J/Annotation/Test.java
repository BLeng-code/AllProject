import java.lang.reflect.Proxy;

@Hello()
class Test {
    public static void main(final String[] args) {
        // Test test = new Test();
        // Hello hello = test.getClass().getAnnotation(Hello.class);
        // System.out.println(hello.msg());

        DataServiceImpl impl = new DataServiceImpl();
        LogHandler logHandler = new LogHandler(impl);
        DataService proxy = (DataService) Proxy.newProxyInstance(
            DataServiceImpl.class.getClassLoader(), 
            DataServiceImpl.class.getInterfaces(), 
            logHandler);
        proxy.sayHello();
        proxy.sayBye();
    }
}