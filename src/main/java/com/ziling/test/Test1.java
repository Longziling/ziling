package com.ziling.test;

public class Test1 {

    public void a() {
        b();
    }

    public void b() {
        c();
    }

    public void c() {
        d();
    }

    public void d() {
        e();
    }

    public void e() {
        StackTraceElement[] array = Thread.currentThread().getStackTrace();
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                StackTraceElement eachElement = array[i];
                System.out.println("className=" + eachElement.getClassName() + " methodName=" + eachElement.getMethodName() + " fileName=" + eachElement.getFileName() + " lineNumber="+ eachElement.getLineNumber());
            }
        }

    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.a();
    }
}
