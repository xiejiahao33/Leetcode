package 设计;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class rc = Class.forName("设计.Test");
        Test r = (Test) rc.newInstance();

        System.out.println(rc.getName());
        r.sayHi("bob");


        //反射获取私有方法，不能获取继承的方法和实现接口的方法
        Method getHello = rc.getDeclaredMethod("throwHello",String.class);
        getHello.setAccessible(true);

        Object str = getHello.invoke(r,"Bonb");
        System.out.println(str);
    }
}
