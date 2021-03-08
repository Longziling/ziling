package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain2;

public class FirstFilter implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====first fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "firstFilter";
        fc.doFilter(tmp, response, fc);
    }
}
