import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogHandler implements InvocationHandler {

    private Object target;

    public LogHandler(Object target){
        this.target = target;
    }

    private void before(){
        System.out.println("before");
    }

    private void after(){
        System.out.println("after");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // TODO Auto-generated method stub
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

}