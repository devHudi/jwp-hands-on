package reflection;

import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit4TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit4Test> clazz = Junit4Test.class;

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            MyTest annotation = method.getAnnotation(MyTest.class);
            if (annotation != null) {
                Junit4Test junit4Test = new Junit4Test();
                method.invoke(junit4Test);
            }
        }

        // TODO Junit4Test에서 @MyTest 애노테이션이 있는 메소드 실행
    }
}
