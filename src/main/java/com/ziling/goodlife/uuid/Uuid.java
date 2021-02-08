package com.ziling.goodlife.uuid;

import java.util.UUID;

public class Uuid {
    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuid);

        String uuid1 = UUID.randomUUID().toString();
        System.out.println(uuid1);
    }
}
