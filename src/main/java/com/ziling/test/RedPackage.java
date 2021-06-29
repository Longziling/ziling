package com.ziling.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RedPackage {

    public static Long[] allocate(Long amount, int number) {
        if (amount < 0 || number < 0) {
            return null;
        }
        Long[] array = new Long[number];
        long count = 0L;
        long sum = 0L;
        int remainingNum = number;
        int i = 1;
        while (remainingNum > 1) {
            count = nextLong(1, 2 * (amount / remainingNum));
            sum += count;
            System.out.println("第" + i + "个人领取的红包金额为：" + count);
            amount -= count;
            remainingNum--;
            array[i - 1] = count;
            i++;
        }
        array[i - 1] = amount;
        System.out.println("第" + i + "个人领取的红包金额为：" + count);
        sum += amount;
        System.out.println(amount);
        System.out.println("验证发出的红包总金额为： " + sum);
        return array;

    }

    private static Long nextLong(final long min, final long max) {
        return min + min + (((long) (new Random().nextDouble() * (max - min))));
    }


    /**
     * 生成min到max范围的浮点数
     **/
    public static double nextDouble(final double min, final double max) {
        return min + ((max - min) * new Random().nextDouble());
    }

    public static String format(double value) {

        return new java.text.DecimalFormat("0.00").format(value); // 保留两位小数
    }


    //二倍均值法
    public static List<Double> doubleMeanMethod(double money, int number){
        List<Double> result = new ArrayList<Double>();
        if(money<0&&number<1)
            return null;
        double amount,sum=0;
        int remainingNumber=number;
        int i=1;
        while(remainingNumber>1){
            amount= nextDouble(0.01,2*(money/remainingNumber));
            sum+=amount;
            System.out.println("第"+i+"个人领取的红包金额为："+format(amount));
            money -= amount;
            remainingNumber--;
            result.add(amount);
            i++;
        }
        result.add(money);
        System.out.println("第"+i+"个人领取的红包金额为："+format(money));
        sum+=money;
        System.out.println("验证发出的红包总金额为："+format(sum));

        return result;


    }



    public static void main(String[] args) {
//        allocate(100L, 20);

        doubleMeanMethod(100, 20);
    }

}
