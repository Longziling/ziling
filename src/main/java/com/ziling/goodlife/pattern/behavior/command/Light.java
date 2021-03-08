package com.ziling.goodlife.pattern.behavior.command;

public class Light {

    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(this.name + " Light is on");
    }

    public void off() {
        System.out.println(this.name + " Light is off");
    }
}
