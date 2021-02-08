package com.ziling.goodlife.design.composite;

public class Main2 {

    public static void main(String[] args) {
        Composite2 c0 = new Composite2();
        Composite2 c1 = new Composite2();

        Leaf2 leaf1 = new Leaf2("leaf1");
        Leaf2 leaf2 = new Leaf2("leaf2");
        Leaf2 leaf3 = new Leaf2("leaf3");

        c0.add(leaf1);
        c0.add(c1);

        c1.add(leaf2);
        c1.add(leaf3);

        c0.operation();
    }

}
