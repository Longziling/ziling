package com.ziling.goodlife.design.composite;

import java.util.ArrayList;

public class Composite implements Component {

    private ArrayList<Component> childList = new ArrayList<>();

    @Override
    public void add(Component c) {
        childList.add(c);
    }

    @Override
    public void remove(Component c) {
        childList.remove(c);
    }

    @Override
    public Component getChild(int i) {
        return childList.get(i);
    }

    @Override
    public void operation() {
        for (Component component : childList) {
            component.operation();
        }
    }
}
