package com.ziling.goodlife.pattern.behavior.responsibilitychain.chain2;

import java.util.ArrayList;
import java.util.List;

public class FilterChainShaoXi implements IFilterShaoxi {

    List<IFilterShaoxi> filterShaoxis = new ArrayList<>();
    int index = 0;
    public FilterChainShaoXi addFilter(IFilterShaoxi filterShaoxi){
        filterShaoxis.add(filterShaoxi);
        return this;
    }
    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        if(index == filterShaoxis.size()){
            return ;
        }
        IFilterShaoxi filter = filterShaoxis.get(index);
        index++;
        filter.doFilter(request, response, fc);
    }

    public static void main(String[] args) {
        FilterChainShaoXi filterChainShaoXi=new FilterChainShaoXi();
        filterChainShaoXi.addFilter(new FirstFilter());
        filterChainShaoXi.addFilter(new SecondFilter());
        filterChainShaoXi.addFilter(new ThirdFilter());
        filterChainShaoXi.addFilter(new WriteFilter());
        filterChainShaoXi.doFilter("yandaye-", "", filterChainShaoXi);
    }
}
