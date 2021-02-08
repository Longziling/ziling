package com.ziling.goodlife.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

import org.python.google.common.collect.Maps;

public class ThredQuery  implements Callable<List<Map<String, Object>>> {
    private Object myService;//需要通过够早方法把对应的业务service传进来 实际用的时候把类型变为对应的类型
    private String sex;//查询条件 根据条件来定义该类的属性

    private int bindex;//分页index
    private int num;//数量

    /**
     * 重新构造方法
     * @param myService
     * @param sex
     * @param bindex
     * @param num
     */
    public ThredQuery(Object myService,String sex,int bindex,int num){
        this.myService=myService;
        this.sex=sex;
        this.bindex=bindex;
        this.num=num;
    }

    @Override
    public List<Map<String, Object>> call() throws Exception {
        //通过service查询得到对应结果
        List<Map<String, Object>>  list  =new ArrayList<>(); //myService.queryBySex(sex,bindex,num);
        Map<String, Object> map1 = Maps.newHashMap();
        Random random = new Random();
        int a = random.nextInt(400);
        System.out.println(a);
        Thread.sleep(1200 + a);
        map1.put(System.currentTimeMillis() + "", System.currentTimeMillis());

        map1.put(System.currentTimeMillis() + 1 + "", System.currentTimeMillis() + 1);

        Map<String, Object> map2 = Maps.newHashMap();

        map2.put(System.currentTimeMillis() + "", System.currentTimeMillis());

        map2.put(System.currentTimeMillis() + 1 + "", System.currentTimeMillis() + 1);

        Map<String, Object> map3 = Maps.newHashMap();

        map3.put(System.currentTimeMillis() + "", System.currentTimeMillis());

        map3.put(System.currentTimeMillis() + 1 + "", System.currentTimeMillis() + 1);

        list.add(map1);
        list.add(map2);
        list.add(map3);

        return list;
    }
}