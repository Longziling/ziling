package com.ziling.goodlife.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.python.google.common.collect.Lists;

public class QueryTest {

//    Object myService;

    public  List<Map<String, Object>> getMaxResult(String sex) throws Exception{
        long start = System.currentTimeMillis();
        List<Map<String, Object>> result=new ArrayList<>();//返回结果

        int count = 20005;//mydao.getCount(); 通过count查到数据总量

        int num = 10000;//每次查询的条数
        //需要查询的次数
        int times=count / num;
        if(count%num !=0) {
            times=times+1;
        }
        //开始查询的行数
        int bindex = 0;

        List<Callable<List<Map<String, Object>>>> tasks = new ArrayList<Callable<List<Map<String, Object>>>>();//添加任务
        for(int i = 0; i <times ; i++){
//            Callable<List<Map<String, Object>>> qfe = new ThredQuery(myService,sex,bindex, num);
            Callable<List<Map<String, Object>>> qfe = new ThredQuery(null,sex,bindex, num);
            tasks.add(qfe);
            bindex=bindex+num;
        }
        //定义固定长度的线程池  防止线程过多
        ExecutorService execservice = Executors.newFixedThreadPool(5);

        List<Future<List<Map<String, Object>>>> futures = execservice.invokeAll(tasks);
        

        // 处理线程返回结果
        if (futures != null && futures.size() > 0) {
            for(Future<List<Map<String, Object>>> future : futures) {
                result.addAll(future.get(1, TimeUnit.SECONDS));
            }
        }
        execservice.shutdown();  // 关闭线程池

        long end = System.currentTimeMillis();
        System.out.println("用时"+(end-start));

        return result;
    }

    public static void main(String[] args) throws Exception {
        QueryTest queryTest = new QueryTest();
        System.out.println(queryTest.getMaxResult(""));
    }
}
