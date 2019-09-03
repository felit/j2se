package com.livedrof.j2se.validation;

import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


/**
 * jsr305 jsr308: javax.validation.constraints?
 * spring mvc验证注解
 * hibernate validator constraint
 * http://hibernate.org/validator/documentation/
 * 常用的验证模式
 * https://www.jianshu.com/p/b2318e7aad34
 */
public class ValidationTest {

    @Test
    public void testParams() {
        String kk = "hello";
        System.out.println(System.currentTimeMillis());
        this.testNull(kk);
    }

    /**
     * IllegalStateException
     * java.lang.IllegalStateException: @Nonnull method com/livedrof/j2se/validation/ValidationTest.testNull must not return null
     *
     * @param kk
     * @return
     */
    @Nonnull
    private String testNull(@Nonnull String kk) {
        return null;
    }
//    private void testBlank(@NotBlank String kk)

    @Test
    public void tet() {
        new A().dd();
    }
}

class A {
    //    List<Integer> 继承 List<? extends Number>
    public <T> List<? extends Number> t(List<? super T> b) {
        List<Integer> ss = new ArrayList<>();
        ss.add(123);
        List<? extends Number> kk = new ArrayList<>();
        return ss;
    }

    public void dd() {
        List<? extends Number> dd = this.t(new ArrayList<Object>());
        List<? super Number> ss= new ArrayList<>();
        ss.add(new Long(2));
    }

    //TODO 泛型相关内容、把运行期的类型错误转换成编译期的类型错误。减少程序员出错的机率，JDK5引入了泛型，JDK7引入自动推断
    //TODO 泛型与集合 泛型接口设计
    //TODO JDK中的泛型示例，泛型在应用设计中的应用 RxJava中的应用，Spring中的应用
    //TODO 泛型的数学原理，协变与逆变->scala的泛型->函数编程
}