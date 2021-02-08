package com.ziling.goodlife.design.single;

/**
 * 双重检查[推荐用]]
 *
 * Double-Check概念对于多线程开发者来说不会陌生，如代码中所示，我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，直接return实例化对象。
 *
 * 优点：线程安全；延迟加载；效率较高。
 */
public class Singleton6 {

    private static volatile Singleton6 INSTANCE;

    private Singleton6() {}

    public static Singleton6 getInstance() {
        if (null == INSTANCE) {
            synchronized(Singleton6.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Singleton6();
                }
            }
        }
        return INSTANCE;
    }
}
