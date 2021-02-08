package com.ziling.goodlife.design.composite;

/**
 * 透明式抽象构建
 */
public interface Component {

    public void add (Component c);

    public void remove(Component c);

    public Component getChild(int i);

    public void operation();

}
