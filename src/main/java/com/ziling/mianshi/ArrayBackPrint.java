package com.ziling.mianshi;

/**
 * @Author: yipeng
 * @Date: 2021/7/27 17:43
 */
public class ArrayBackPrint {

    public static void arrayBackPrint(int[][] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid param");
        }
        if (nums.length == 0) {
            return;
        }
        int top = 0;
        int bottom =  nums.length - 1;
        int left =0;
        int right = nums[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                System.out.print(nums[top][i] + " ");
            }
            top++;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = top; i <= bottom; i++) {
                System.out.print(nums[i][right] + " ");
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = right; i >= left; i--) {
                System.out.print(nums[bottom][i] + " ");
            }
            bottom--;
            if (top > bottom || left > right) {
                break;
            }
            for (int i = bottom; i >= top; i--) {
                System.out.print(nums[i][left] + " ");
            }
            left++;
            System.out.println();
        }
    }

    public static void arrayPrint(int[][] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid param");
        }
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void arrayInnit(int[][] nums) {
        if (nums == null) {
            throw new RuntimeException("invalid param");
        }
        if (nums.length == 0) {
            return;
        }
        int num = 11;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                nums[i][j] = num++;
            }
        }
    }

    public static void main(String[] args) {
//        int[][] nums = new int[10][7];
        int[][] nums = new int[10][10];
        arrayInnit(nums);
        arrayPrint(nums);
        arrayBackPrint(nums);
    }

}
