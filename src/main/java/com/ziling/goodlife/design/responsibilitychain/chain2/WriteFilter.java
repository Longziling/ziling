package com.ziling.goodlife.design.responsibilitychain.chain2;

public class WriteFilter implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====wirte fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "wirteFilter";
        fc.doFilter(tmp, response, fc);
    }
}
