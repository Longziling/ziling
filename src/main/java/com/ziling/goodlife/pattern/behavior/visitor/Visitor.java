package com.ziling.goodlife.pattern.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式
 *
 * 将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离
 *
 */
public class Visitor {
    public static void main(String[] args){
        List<Person> list = Allperson.getList();
        System.out.println("得到名字:");
        for(Person e: list){
            e.accept(new VisitorName());
        }
        System.out.println("得到年龄:");
        for(Person e: list){
            e.accept(new VisitorAge());
        }
    }
}

interface Person {
    void accept(IVisitor visitor);
}

interface IVisitor {
    void visit(Student student);
    void visit(Teacher teacher);
}

class Student implements Person {
    private String name;
    private int age;
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class Teacher implements Person {
    private String name;
    private int age;
    public Teacher(String name,int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

class VisitorName implements IVisitor {

    public void visit(Student student) {
        System.out.println(student.getName());
    }

    public void visit(Teacher teacher) {
        System.out.println(teacher.getName());
    }
}

class VisitorAge implements IVisitor {

    public void visit(Student student) {
        System.out.println(student.getAge());
    }

    public void visit(Teacher teacher) {
        System.out.println(teacher.getAge());
    }
}

class Allperson {
    public static List<Person> getList(){
        List<Person> list = new ArrayList<Person>();
        Student s1 = new Student("路飞",20);
        Student s2 = new Student("索隆",19);
        Teacher t1 = new Teacher("红发",44);
        Teacher t2 = new Teacher("雷利",59);
        list.add(s1);
        list.add(s2);
        list.add(t1);
        list.add(t2);
        return list;
    }
}
