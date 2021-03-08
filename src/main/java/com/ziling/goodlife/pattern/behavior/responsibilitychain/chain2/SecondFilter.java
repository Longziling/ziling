package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain2;

public class SecondFilter implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====second fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "secondFilter";
        fc.doFilter(tmp, response, fc);
    }
}