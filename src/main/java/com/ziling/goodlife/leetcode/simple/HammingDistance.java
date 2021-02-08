package com.ziling.goodlife.leetcode.simple;

/**
 * 汉明距离
 *
 * 难度：简单
 *
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int hammingDistance = 0;
        while (a / 2 > 0) {
            if (a % 2 > 0) {
                hammingDistance++;
            }
            a /= 2;
        }
        if (a > 0) {
            hammingDistance++;
        }
        return hammingDistance;
    }

    public int hammingDistance1(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

    /*
        布赖恩·克尼根算法

        思路

        方法二是逐位移动，逐位比较边缘位置是否为 1。寻找一种更快的方法找出等于 1 的位数。

        是否可以像人类直观的计数比特为 1 的位数，跳过两个 1 之间的 0。例如：10001000。

        上面例子中，遇到最右边的 1 后，如果可以跳过中间的 0，直接跳到下一个 1，效率会高很多。

        这是布赖恩·克尼根位计数算法的基本思想。该算法使用特定比特位和算术运算移除等于 1 的最右比特位。

        当我们在 number 和 number-1 上做 AND 位运算时，原数字 number 的最右边等于 1 的比特会被移除。

     */
    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }

    public int hammingDistance3(int x, int y) {
        return Integer.bitCount(x ^ y);
    }


    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        System.out.println(hammingDistance.hammingDistance(0,4));
    }

}
