package com.ziling.goodlife.data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList();
        studentList.add(new Student(12, "river"));
        studentList.add(new Student(12, "lucy"));
        studentList.add(new Student(33, "frank"));
        studentList.add(new Student(33, "lucy"));

        List<Student> studentDistinctList = studentList.stream()
                .collect(Collectors.collectingAndThen
                        (Collectors.toCollection(() ->
                                        new TreeSet<>(Comparator.comparing(t -> t.getName()))),
                                ArrayList::new
                        )
                );
        for (Student s : studentDistinctList) {
            System.out.println(s.getName());
        }
        Set<Student> studentDistinctSet1 = studentList.stream()
                .filter(t -> t.getAge() == 33).collect(Collectors.toSet());

        for (Student s : studentDistinctSet1) {
            System.out.println(s.getName());
        }

        Set<Student> studentDistinctSet2 = studentList.stream()
                .filter(t -> t.getAge() == 12).collect(Collectors.toSet());


        for (Student s : studentDistinctSet2) {
            System.out.println(s.getName());
        }

        studentDistinctSet2.addAll(studentDistinctSet1);

        System.out.println("-----------------------------------------------");
        for (Student s : studentDistinctSet2) {
            System.out.println(s.getName() + "" + s.getAge());
        }

    }
}
