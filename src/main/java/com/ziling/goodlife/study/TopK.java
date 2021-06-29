package com.ziling.goodlife.study;

/**
 * @Author: yipeng
 * @Date: 2021/6/21 20:28
 */
public class TopK {

    /**
     * 最小堆的结构调整
     * @param arr   数组
     * @param index   结束位置
     */
    private static void adjustHeap(int[] arr, int index) {
        // 获取父节点坐标
        for (int i = index / 2; i > 0; i--) {
            // 记录父节点值（遍历过程中，第一次执行到此处时，记录父节点的值，相当于一个temp，只用于记录值。该值最终会替换掉遍历过程中最小的那个值）
            int parentVal = arr[i];
            // 记录父节点下标（该下标值，会在下面遍历中位置下推）
            int parentIndex = i;
            // 不超过index节点情况下，遍历该父节点下子节点情况。
            while (parentIndex * 2 <= index) {
                // 获取当前父节点的左节点
                int childIndex = parentIndex * 2;
                // 判断两个儿子节点的大小，获取较小的一个儿子节点（循环遍历较小的一个，最小的最后会被替换掉）
                if (childIndex != index && arr[childIndex] > arr[childIndex + 1]) {
                    childIndex++;
                }
                // 较小子节点比父节点的值（相当于temp）大，说明该次遍历完成
                if (parentVal < arr[childIndex]) {
                    break;
                } else {
                    // 子节点较小的值放到当前父节点下标位置
                    arr[parentIndex] = arr[childIndex];
                }
                // 当前父节点下标位置下推到之前较小子节点下标位置（此处完成父节点的下标位置下推）
                parentIndex = childIndex;
            }
            // 将父节点的值（相当于temp）替换到父节点当前下标位置
            arr[parentIndex] = parentVal;
        }
    }

    private static void print(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {34,23,6435,4234,2523,425235,234234,6345,23,54,43,23,23,43,53,2,423,6345,432,24,25,2,234,53,6546,5345,2342,63534,234,4364};
        int k = 10;
        int[] arr = new int[k + 1];
        arr[0] = Integer.MAX_VALUE;
        print(nums, 0);
        System.arraycopy(nums, 0, arr, 1, k);
        print(arr, 1);
        // 建立小顶堆
        adjustHeap(arr, k);
        print(arr, 1);
        for (int i = k; i < nums.length; i++) {
            //
            if (nums[i] > arr[1]) {
                arr[1] = nums[i];
                adjustHeap(arr, k);
            }
        }
        print(arr, 1);
    }

}
