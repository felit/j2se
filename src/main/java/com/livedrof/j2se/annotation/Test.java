package com.livedrof.j2se.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TestAnnotation(id = 100, msg = "hello annotation")
public class Test {
    @Check(value = "hi")
    private int a;

    @Perform
    public void testMethod() {

    }

    @SuppressWarnings("deprecation")
    public void test1() {

    }

    public static void main(String[] args) {

        boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);

        if (hasAnnotation) {
            TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }


//        字段注解
        Field a = null;
        try {
            a = Test.class.getDeclaredField("a");
            a.setAccessible(true);
            Check check = a.getAnnotation(Check.class);
            if (check != null) {
                System.out.println("check value:" + check.value());
            }


            Method testMethod = Test.class.getDeclaredMethod("testMethod");
            if (testMethod != null) {
                Annotation[] ans = testMethod.getAnnotations();
                for(int i =0;i<ans.length;i++) {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
