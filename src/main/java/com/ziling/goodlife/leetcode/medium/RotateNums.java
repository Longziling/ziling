package com.ziling.goodlife.leetcode.medium;

public class RotateNums {

    /**
     * 时间复杂度： O(n)，其中n为数组的长度。
     * 空间复杂度： O(n)。
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }

    /**
     * 三次反转
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k -1 );
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    /**
     * 环状替换
     * 遍历总数为数组长度n与位置k的最大公约数（数学推导得证）
     * 时间复杂度：O(n)，其中 n 为数组的长度。每个元素只会被遍历一次。
     * 空间复杂度：O(1)。我们只需常数空间存放若干变量。
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int i = 0; i < count; i++) {
            int current = i;
            int prev = nums[i];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (current != i);
        }

    }

    /**
     * 最大公约数
     * @param x
     * @param y
     * @return
     */
    public static int gcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        return y > 0 ? gcd(y, x % y) : x;
    }


    public static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] a = {0,1,2,4,5,6,7};
        RotateNums rotateNums = new RotateNums();
        rotateNums.rotate(a, 2);
        print(a);
    }
}
