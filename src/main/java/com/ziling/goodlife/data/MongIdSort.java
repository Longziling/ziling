package com.ziling.goodlife.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MongIdSort {

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId("5cef369f14220000068f056e");
        s1.setName("张三");
        Student s2 = new Student();
        s2.setId("5ce255440b4a6d0007efa718");
        s2.setName("李四");
        Student s3 = new Student();
        s3.setId("5d009b49fc9b870006081dcd");
        s3.setName("王二");
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        Collections.sort(list,new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                // TODO Auto-generated method stub
                return o2.id.compareTo(o1.id);
            }
        });

        System.out.println(list);

        for (Student s : list) {
            System.out.println(s.getId());
        }
    }

    static class Student{
        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
