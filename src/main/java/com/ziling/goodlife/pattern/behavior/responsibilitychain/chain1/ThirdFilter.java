package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain1;

public class ThirdFilter extends AbstractFilter {

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