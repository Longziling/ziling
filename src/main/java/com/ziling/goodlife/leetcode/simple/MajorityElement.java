package com.ziling.goodlife.leetcode.simple;

/**
 * 多数元素
 *
 * 难度：简单
 *
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 1, 1, 1, 5, 7,1, 1, 5};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println(majorityElement.majorityElement(nums));
    }


    /**
     * Boyer-Moore 投票算法(大前提，一定有众数)
     * 如果我们把众数记为 +1，把其他数记为 -1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
     * 时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
     * 空间复杂度：O(1)。Boyer-Moore 算法只需要常数级别的额外空间。
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }




    private int majorityElementRec(int[] nums, int low, int hight) {
        if (low == hight) {
            return nums[low];
        }
        int mid = (low + hight) >> 1;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, hight);
        return pushUp(left, right, low, hight, nums);
    }

    private int pushUp(int left, int right, int low, int hight, int[] nums) {
        if (left == right) {
            return left;
        }
        int leftCount = countInRange(nums, left, low, hight);
        int rightCount = countInRange(nums, right, low, hight);

        return leftCount > rightCount ? left : right;
    }


    /**
     * 分治算法
     * 时间复杂度：O(nlogn)。
     * 空间复杂度：O(logn)
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        return majorityElementRec(nums, 0, nums.length-1);
    }

    private int countInRange(int[] nums, int num, int low, int hight) {
        int count = 0;
        for (int i = low; i <= hight; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }


}
