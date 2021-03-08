package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain1;

public abstract class AbstractFilter implements Ordered{

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
