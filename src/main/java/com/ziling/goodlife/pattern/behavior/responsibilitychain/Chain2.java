package com.ziling.goodlife.pattern.behavior.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

public class Chain2 {
    public static void main(String[] args) {
        FilterChainShaoXi filterChainShaoXi=new FilterChainShaoXi();
        filterChainShaoXi.addFilter(new First());
        filterChainShaoXi.addFilter(new Second());
        filterChainShaoXi.addFilter(new Third());
        filterChainShaoXi.addFilter(new Write());
        filterChainShaoXi.doFilter("yandaye-", "", filterChainShaoXi);
    }
}

interface IFilterShaoxi {
    void doFilter(Object request, Object response, IFilterShaoxi fc);
}

class First implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====first fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "firstFilter";
        fc.doFilter(tmp, response, fc);
    }
}

class Second implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====second fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "secondFilter";
        fc.doFilter(tmp, response, fc);
    }
}

class Third implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====third fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "thirdFilter";
        fc.doFilter(tmp, response, fc);
    }
}

class Write implements IFilterShaoxi {

    @Override
    public void doFilter(Object request, Object response, IFilterShaoxi fc) {
        System.out.println("=====wirte fitler before====");
        System.out.println(request);
        String tmp = String.valueOf(request);
        tmp = tmp + "wirteFilter";
        fc.doFilter(tmp, response, fc);
    }
}

class FilterChainShaoXi implements IFilterShaoxi {

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

}

