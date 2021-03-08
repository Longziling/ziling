package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain1;

public class SecondFilter extends AbstractFilter {

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
