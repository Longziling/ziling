package com.ziling.goodlife.jdk.lang.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * 自己写一个类加载器 ，去加载"d:\myclass\com\wyp12\*.class"
 *
 * @author prince
 *
 */
public class MyClassLoader extends ClassLoader {
    private String name;
    public MyClassLoader(String name) {
        super(); // 通过这个构造方法生成的类加载器，它的父加载器是系统类加载器
        this.name = name;
    }
    public MyClassLoader(String name, ClassLoader loader) {
        super(loader); // 通过这个这个构造方法生成的类加载器，该加载器的父加载器是loader,如果为空，则父加载器为根加载器
        // 子类继承父类，如果不显式写出调用父类的哪个构造方法，那么就默认调用父类的无参构造函数
        this.name = name;
    }
    public String toString()
    {
        return this.name;
    }
    // 要重写findclass这个方法，loadclass会调用它
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\testSpace\\ziling\\target\\classes\\com\\ziling\\goodlife\\jdk\\lang\\classloader\\"+name+".class");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ByteArrayOutputStream abos = new ByteArrayOutputStream();
        int ch = 0;
        try {
            while (-1!=(ch=fis.read()))
            {
                abos.write(ch);        //把字节一个一个写到输出流中
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        data = abos.toByteArray();   //把输出流中的字节弄成一个字节数组
        return this.defineClass("com.ziling.goodlife.jdk.lang.classloader."+name,data, 0, data.length,null);
    }
}
