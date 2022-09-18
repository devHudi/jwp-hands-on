package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Test;

class Junit3TestRunner {

    @Test
    void run() throws Exception {
        Class<Junit3Test> clazz = Junit3Test.class;

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            invokeMethod(method);
        }
    }

    private void invokeMethod(final Method method) throws IllegalAccessException, InvocationTargetException {
        Junit3Test junit3Test = new Junit3Test();

        String methodName = method.getName();
        if (methodName.startsWith("test")) {
            method.invoke(junit3Test);
        }
    }
}
