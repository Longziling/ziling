package com.ziling.goodlife.function;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FunctionTest {

    public static void main(String[] args) {
        Function<String, EventInfo> times2 = t -> { EventInfo a = new EventInfo(); a.setName(t); return a;};
        String[] testintStrings={"1","2","3","4"};

        //将String 的Array转换成map,调用times2函数进行转换
        Map<String,EventInfo> eventmap1= Stream.of(testintStrings).collect(Collectors.toMap(inputvalue->inputvalue, times2::apply));

//        System.out.println(eventmap1);
        for (Map.Entry<String,EventInfo> entry : eventmap1.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().getName());
        }
    }

     static class EventInfo {
        public String name;

        public String getName() {
            return name;
        }

        public void  setName(String name) {
            this.name = name;
        }
    }
}
