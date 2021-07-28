package com.ziling.mianshi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yipeng
 * @Date: 2021/7/21 11:34
 */
public class ForEachTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        testContine(list);
        testBreak(list);
    }


    public static void testContine(List<Integer> list) {
        list.forEach(item -> {
            if (item.equals(4)) {
                return;
            }
            System.out.println(item);
        });
        System.out.println("end");

    }

    public static void testBreak(List<Integer> list) {
        try {
            list.forEach(item -> {
                if (item.equals(4)) {
                    throw new RuntimeException();
                }
                System.out.println(item);
            });
        } catch (Exception e) {

        }
        System.out.println("end");
    }

}
