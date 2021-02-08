package com.ziling.goodlife.design.composite;

import java.util.ArrayList;

public class Composite2 implements Component2 {

    private ArrayList<Component2> childList = new ArrayList<>();

    public void add(Component2 c) {
        childList.add(c);
    }

    public void remove(Component2 c) {
        childList.remove(c);
    }

    public Component2 getChild(int i) {
        return childList.get(i);
    }

    @Override
    public void operation() {
        for (Component2 component2 : childList) {
            component2.operation();
        }
    }
}
