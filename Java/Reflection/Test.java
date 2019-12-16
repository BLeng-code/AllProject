import java.lang.reflect.Method;

import com.module.annotation.SayHello;

class Test {
    public static void main(String[] args) {
        try {
            
            Class t = Class.forName("com.module.hello.Hello");
            Object o = t.newInstance();
            Method[] methods = t.getMethods();
            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                SayHello anno = method.getAnnotation(SayHello.class);
                if (anno != null) {
                    method.invoke(o, "lb");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}