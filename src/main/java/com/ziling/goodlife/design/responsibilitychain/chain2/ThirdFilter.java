package com.ziling.goodlife.design.responsibilitychain.chain2;

public class ThirdFilter implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====third fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "thirdFilter";
        fc.doFilter(tmp, response, fc);
    }
}
