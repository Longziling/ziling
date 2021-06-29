package com.ziling.goodlife.alibaba;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Author: yipeng
 * @Date: 2021/6/18 14:25
 *
 * 一致性哈希
 *
 */
public class ConsistentHashingWithoutVirtualNode {

    private static String[] servers = {"192.168.0.0:111", "192.168.0.1:111", "192.168.0.2:111", "192.168.0.3:111", "192.168.0.4:111"};

    private static SortedMap<Integer, String> sortedMap = new TreeMap<>();

    static {
        for (int i = 0; i < servers.length; i++) {
            int hash = getHash(servers[i]);
            System.out.println(servers[i] + "加入集合" + hash);
            sortedMap.put(hash, servers[i]);

        }
        System.out.println();
    }

    public static String getServer(String key) {
        int hash = getHash(key);
        SortedMap<Integer, String> subMap = sortedMap.tailMap(hash);
        if (subMap.isEmpty()) {
            Integer a = sortedMap.firstKey();
            return sortedMap.get(a);
        } else {
            Integer b = subMap.firstKey();
            return subMap.get(b);
        }
    }

    //使用FNV1_32_HASH算法计算服务器的Hash值,这里不使用重写hashCode的方法，最终效果没区别
    private static int getHash(String str) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        for (int i = 0; i < str.length(); i++)
            hash = (hash ^ str.charAt(i)) * p;
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 如果算出来的值为负数则取其绝对值
        if (hash < 0)
            hash = Math.abs(hash);
        return hash;
    }


    public static void main(String[] args) {
        String[] keys = {"太阳", "月亮", "星星"};
        for(int i=0; i<keys.length; i++)
            System.out.println("[" + keys[i] + "]的hash值为" + getHash(keys[i])
                    + ", 被路由到结点[" + getServer(keys[i]) + "]");
    }


}
