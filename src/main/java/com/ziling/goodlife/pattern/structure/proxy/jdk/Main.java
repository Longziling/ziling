package com.ziling.goodlife.pattern.structure.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public void test1() throws Exception {
        Foo foo = new RealFoo();
        // 根据类加载器和接口数组获取代理类的Class对象
        Class<?> proxyClass = Proxy.getProxyClass(Foo.class.getClassLoader(), Foo.class);

        // 通过Class对象的构造器创建一个实例（代理类的实例）
        Foo fooProxy = (Foo) proxyClass.getConstructor(InvocationHandler.class)
                .newInstance(new MyInvocationHandler(foo));
        // 调用 ping 方法，并输出返回值
        String value = fooProxy.ping("杨过");
        System.out.println(value);

    }


    public void test2() {
        Foo foo = new RealFoo();
        // 通过类加载器、接口数组和调用处理器，创建代理类的实例
        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[]{Foo.class},
                new MyInvocationHandler(foo));
        String value = fooProxy.ping("小龙女");
        System.out.println(value);
    }

    public void test3() {
        Foo foo = new RealFoo();

        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[]{Foo.class},
                (proxy, method, args) -> method.invoke(foo, args));
        String value = fooProxy.ping("雕兄");
        System.out.println(value);
    }

    public void test4() {
        Foo foo = new RealFoo();
        Foo fooProxy = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
                new Class[]{Foo.class},
                (proxy, method, args) -> method.invoke(foo, args));
        String value = fooProxy.ping("郭靖");
        System.out.println(value);
    }




    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.test1();
        System.out.println("----------------------------------------------");
        main.test2();
        System.out.println("----------------------------------------------");
        main.test3();
        System.out.println("----------------------------------------------");
        main.test4();
    }


}
