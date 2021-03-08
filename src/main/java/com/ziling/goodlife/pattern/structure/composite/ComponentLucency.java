package com.ziling.goodlife.pattern.structure.composite;


import java.util.ArrayList;

/**
 * 组合模式——透明式抽象构建
 *
 * 透明组合模式是把组合使用的方法放到抽象类中，不管叶子对象和树枝对象都是相同的结构，
 * 这样做的好处就是叶子节点和树枝节点对于外界没有区别，他们具有完全一致的行为接口，
 * 但因为 Leaf 叶子节点类本身并不具备 add(),remove(),getChild()功能，所以实现它是没有意义的
 *
 */
public class ComponentLucency {

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

interface Component {

    void add (Component c);

    void remove(Component c);

    Component getChild(int i);

    void operation();

}

class Composite implements Component {

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

class Leaf implements Component {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void add(Component c) {

    }

    @Override
    public void remove(Component c) {

    }

    @Override
    public Component getChild(int i) {
        return null;
    }

    @Override
    public void operation() {
        System.out.println("透明式--叶子：" + name + " 被访问");
    }
}

