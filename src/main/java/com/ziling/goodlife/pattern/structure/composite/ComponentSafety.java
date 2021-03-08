package com.ziling.goodlife.pattern.structure.composite;

import java.util.ArrayList;

/**
 * 组合模式——安全式构建
 *
 * 安全组合模式不声明管理子类的接口，声明和管理子类的接口交给子类自己去完成
 *
 */
public class ComponentSafety {

    public static void main(String[] args) {
        CompositeSafe c0 = new CompositeSafe();
        CompositeSafe c1 = new CompositeSafe();

        LeafSafe leaf1 = new LeafSafe("leaf1");
        LeafSafe leaf2 = new LeafSafe("leaf2");
        LeafSafe leaf3 = new LeafSafe("leaf3");

        c0.operation();
        c0.add(leaf1);
        c0.add(c1);

        c1.add(leaf2);
        c1.add(leaf3);

        c0.operation();
    }

}


interface ComponentSafe {

    void operation();

}

class CompositeSafe implements ComponentSafe {

    private ArrayList<ComponentSafe> childList = new ArrayList<>();

    public void add(ComponentSafe c) {
        childList.add(c);
    }

    public void remove(ComponentSafe c) {
        childList.remove(c);
    }

    public ComponentSafe getChild(int i) {
        return childList.get(i);
    }

    @Override
    public void operation() {
        for (ComponentSafe componentSafe : childList) {
            componentSafe.operation();
        }
    }
}

class LeafSafe implements ComponentSafe {

    private String name;

    public LeafSafe(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("安全式--叶子： " + name + " 被访问");
    }
}



