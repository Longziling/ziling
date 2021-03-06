package com.ziling.goodlife.leetcode.medium;

/**
 * 两数相加
 *
 * 难度：中等
 *
 * 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，从而可以得到恰好 z升 的水？
 *
 * 如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。
 *
 * 你允许：
 *
 * 装满任意一个水壶
 * 清空任意一个水壶
 * 从一个水壶向另外一个水壶倒水，直到装满或者倒空
 * 示例 1: (From the famous "Die Hard" example)
 *
 * 输入: x = 3, y = 5, z = 4
 * 输出: True
 * 示例 2:
 *
 * 输入: x = 2, y = 6, z = 5
 * 输出: False
 *
 *
 * https://leetcode-cn.com/problems/water-and-jug-problem/
 */

public class CanMeasureWater {

    // 贝祖定理：ax+by=z 有解当且仅当 z 是 x,y 的最大公约数的倍数
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }

    public static void main(String[] args) {
        CanMeasureWater canMeasureWater = new CanMeasureWater();
        System.out.println(canMeasureWater.canMeasureWater(2,4, 18));
    }



}
