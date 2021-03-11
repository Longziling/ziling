package com.ziling.goodlife.pattern.behavior.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式/职责链模式
 *
 * 为了避免请求发送者与多个请求处理者耦合在一起，将所有请求的处理者通过前一对象记住其下一个对象的引用而连成一条链；当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止。
 *
 */
public class Chain1 {

    public static AbstractFilter init(){
        List<AbstractFilter> filterList = new ArrayList<>();

        filterList.add(new SecondFilter());
        filterList.add(new ThirdFilter());
        filterList.add(new FirstFilter());
        /*
         * 这里可以加排序
         */
        filterList.sort((e, h) -> e.getOrder() > h.getOrder() ? 1 : -1);

        for(int i = 0; i < filterList.size() - 1; i++){
            AbstractFilter filter = filterList.get(i);
            AbstractFilter nextFilter = filterList.get(i + 1);
            filter.setNext(nextFilter);
        }
        return filterList.get(0);
    }

    public static void main(String[] args) {
        init().doFilter("yan", "resp");
    }

}

interface Ordered {
    public int getOrder();
}

abstract class AbstractFilter implements Ordered{

    protected AbstractFilter filter;

    public abstract void doFilter(String request, String resp);

    public void setNext(AbstractFilter filter) {
        this.filter = filter;
    }

    public void next(String request, String resp){
        if (null != this.filter){
            filter.doFilter(request, resp);
        }
    }
}

class FirstFilter extends AbstractFilter {

    @Override
    public void doFilter(String request, String resp) {
        System.out.println("=====first filter" + request);
        next(request, resp);
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

class SecondFilter extends AbstractFilter {

    @Override
    public void doFilter(String request, String resp) {
        System.out.println("=====second filter" + request);
        next(request, resp);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}

class ThirdFilter extends AbstractFilter {

    @Override
    public void doFilter(String request, String resp) {
        System.out.println("=====third filter" + request);
        next(request, resp);
    }

    @Override
    public int getOrder() {
        return 3;
    }
}

