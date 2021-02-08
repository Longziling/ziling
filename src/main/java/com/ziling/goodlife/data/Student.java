package com.ziling.goodlife.data;

import java.util.Objects;

public class Student {
    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Student (Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; //自反性
        if (obj == null || this.getClass() != obj.getClass()) {  //传递性,非空性
            return false;
        }
        return this.getName().equals(((Student) obj).getName());
    }
}
