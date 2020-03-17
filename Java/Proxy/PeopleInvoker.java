import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PeopleInvoker implements InvocationHandler {

    private Object target;

    public PeopleInvoker(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        System.out.println("收取手续费");

        return method.invoke(target, args);
    }

}