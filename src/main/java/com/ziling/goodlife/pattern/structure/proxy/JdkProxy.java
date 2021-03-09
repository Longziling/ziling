package com.ziling.goodlife.pattern.structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy {

    public void test1() throws Exception {
        Foo foo = new RealFoo();
        // 根据类加载器和接口数组获取代理类的Class对象
        Class<?> proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), Foo.class);

        // 通过Class对象的构造器创建一个实例（代理类的实例）
        Foo fooProxy = (Foo) proxyClass.getConstructor(InvocationHandler.class).newInstance(new MyInvocationHandler(foo));
        // 调用 ping 方法，并输出返回值
        String value = fooProxy.ping("杨过");
        System.out.println(value);

    }


    public void test2() {
        Foo foo = new RealFoo();
        // 通过类加载器、接口数组和调用处理器，创建代理类的实例
        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, new MyInvocationHandler(foo));
        String value = fooProxy.ping("小龙女");
        System.out.println(value);
    }

    public void test3() {
        Foo foo = new RealFoo();

        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, (proxy, method, args) -> method.invoke(foo, args));
        String value = fooProxy.ping("雕兄");
        System.out.println(value);
    }

    public void test4() {
        Foo foo = new RealFoo();
        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(), new Class[]{Foo.class}, (proxy, method, args) -> {
                    System.out.println("proxy - " + proxy.getClass());
                    System.out.println("method - " + method);
                    System.out.println("args - " + Arrays.toString(args));
                    return method.invoke(foo, args);
                });
        String value = fooProxy.ping("郭靖");
        System.out.println(value);
    }


    public static void main(String[] args) throws Exception {
        JdkProxy jdkProxy = new JdkProxy();
        jdkProxy.test1();
        System.out.println("----------------------------------------------");
        jdkProxy.test2();
        System.out.println("----------------------------------------------");
        jdkProxy.test3();
        System.out.println("----------------------------------------------");
        jdkProxy.test4();
    }

}

interface Foo {

    String ping(String name);

}

class RealFoo implements Foo {

    @Override
    public String ping(String name) {
        System.out.println("ping");
        return "pong";
    }

}

class MyInvocationHandler implements InvocationHandler {

    // 目标对象
    private final Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy - " + proxy.getClass());
        System.out.println("method - " + method);
        System.out.println("args - " + Arrays.toString(args));
        return method.invoke(target, args);
    }
}

