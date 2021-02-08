package com.ziling.goodlife.string;

import java.util.ArrayList;
import java.util.List;

public class NullTest {
    public static void main(String[] args) {
        String a = null;
        System.out.println(a + "asdfsdf");

        List<String> ids = new ArrayList<>();
        ids.add("34234");
        ids.add("werweq");
        ids.add("5tyrujy");

        List<String> idss = null;

        ids.addAll(idss);

    }
}
