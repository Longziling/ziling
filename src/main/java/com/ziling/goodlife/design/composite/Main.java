package com.ziling.goodlife.design.composite;

public class Main {

    public static void main(String[] args) {
        Component c0 = new Composite();
        Component c1 = new Composite();

        Component leaf1 = new Leaf("leaf1");
        Component leaf2 = new Leaf("leaf2");
        Component leaf3 = new Leaf("leaf3");

        c0.add(leaf1);
        c0.add(c1);

        c1.add(leaf3);
        c1.add(leaf2);

        c0.operation();

    }

}
