package com.ziling.test;

public class YueSeFu {

    public int cir1(int n, int m) {
        int p = 0;
        for(int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }

    public int cir2(int n, int m) {
        int p = 1;
        for (int i = 2; i <= n; i++) {
            p = (p + m - 1) % i + 1;
        }
        return p;
    }

    int cir3(int n, int m){
        return n == 1 ? n : (cir3(n - 1, m) + m - 1) % n + 1;
    }

    public static void main(String[] args) {
        YueSeFu yueSeFu = new YueSeFu();
        System.out.println(yueSeFu.cir1(111, 3));
    }

}
