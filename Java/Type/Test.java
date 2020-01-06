import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;

public class Test<T> { // 泛型变量类型
    public int a; // 原始类型
    List<String> list; // 参数化类型
    List<String>[] lists; // 泛型数组类型
    List<? extends Test> b; // 通配符

    private void sayHello(T t) { // 泛型变量类型，在类上定义，在方法中使用
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        // 获取声明的字段，getFields()方法只能获取public的字段
        Field[] fields = Test.class.getDeclaredFields();
        for (Field field : fields) {
            Type type = field.getGenericType();
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                Type[] types1 = parameterizedType.getActualTypeArguments();
                for (Type type2 : types1) {
                    if (type2 instanceof WildcardType) {
                        WildcardType wildcardType = (WildcardType) type2;
                        Type[] types2 = wildcardType.getUpperBounds();
                        for (Type type3 : types2) {
                            System.out.println(type3.toString());
                        }
                    }
                }
            }
            if (type instanceof GenericArrayType) {
                GenericArrayType genericArrayType = (GenericArrayType) type;
                System.out.println(genericArrayType.getGenericComponentType().toString());
            }
        }
        // 获取声明的方法，getMethods()方法只能获取public的方法
        Method[] methods = Test.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
            Type[] types3 = method.getGenericParameterTypes();
            for (Type type : types3) {
                if (type instanceof TypeVariable) {
                    TypeVariable typeVariable = (TypeVariable) type;
                    System.out.println(typeVariable.toString());
                }
            }
        }
    }
}