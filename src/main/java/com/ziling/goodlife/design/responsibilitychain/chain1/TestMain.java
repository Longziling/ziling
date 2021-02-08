package com.ziling.goodlife.design.responsibilitychain.chain1;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
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
