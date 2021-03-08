package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain1;

public class FirstFilter extends AbstractFilter {

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
