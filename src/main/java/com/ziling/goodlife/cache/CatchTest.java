package com.ziling.goodlife.cache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.python.google.common.cache.CacheBuilder;
import org.python.google.common.cache.CacheLoader;
import org.python.google.common.cache.LoadingCache;
import org.python.google.common.cache.RemovalListener;
import org.python.google.common.cache.RemovalNotification;

public class CatchTest {

    public static void main(String[] args) {
        CatchTest catchTest = new CatchTest();
        try {
            catchTest.testCache();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testCache() throws ExecutionException, InterruptedException {

        CacheLoader cacheLoader = new CacheLoader<String, Animal>() {
            // 如果找不到元素，会调用这里
            @Override
            public Animal load(String s) {
                return null;
            }
        };
        LoadingCache<String, Animal> loadingCache = CacheBuilder.newBuilder()
                .maximumSize(1000) // 容量
                .expireAfterWrite(3, TimeUnit.SECONDS) // 过期时间
                .removalListener(new MyRemovalListener()) // 失效监听器
                .build(cacheLoader); //
        loadingCache.put("狗", new Animal("旺财", 1));
        loadingCache.put("猫", new Animal("汤姆", 3));
        loadingCache.put("狼", new Animal("灰太狼", 4));

        loadingCache.invalidate("猫"); // 手动失效

        Animal animal = loadingCache.get("狼");
        System.out.println(animal.toString());
        Thread.sleep(4 * 1000);
        // 狼已经自动过去，获取为 null 值报错
        System.out.println(loadingCache.get("狼"));
    }

    /**
     * 缓存移除监听器
     */
    class MyRemovalListener implements RemovalListener<String, Animal> {

        @Override
        public void onRemoval(RemovalNotification<String, Animal> notification) {
            String reason = String.format("key=%s,value=%s,reason=%s", notification.getKey(), notification.getValue(), notification.getCause());
            System.out.println(reason);
        }
    }

    class Animal {
        private String name;
        private Integer age;

        public Animal(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String toString(){
            return this.name + this.age;
        }
    }

}
