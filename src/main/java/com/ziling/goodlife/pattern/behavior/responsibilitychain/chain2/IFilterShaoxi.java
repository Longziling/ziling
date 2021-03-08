package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain2;

public interface IFilterShaoxi {
    void doFilter(Object request, Object response, IFilterShaoxi fc);
}
