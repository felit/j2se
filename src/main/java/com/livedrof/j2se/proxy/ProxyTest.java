package com.livedrof.j2se.proxy;

import com.livedrof.j2se.proxy.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler proxy = new MyInvocationHandler(userService);
        UserService userServiceProxy = (UserService)getBean(userService.getClass(),proxy) ;
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));
    }

    /**
     * 由proxy代理klass类的方法
     * @param klass
     * @param proxy
     * @return
     */
    private static Object getBean(Class<?> klass,InvocationHandler proxy) {
        return Proxy.newProxyInstance(klass.getClassLoader(), klass.getInterfaces(), proxy);
    }
}
