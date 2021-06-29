package com.ziling.goodlife.algorithm;

public class TopKmin {

    /**
     * 最小的K个数，O(N)解法，需要修改原数组
     * @param a
     * @param k
     */
    public int[] topKmin(int[] a, int k) {
        if (a == null || k > a.length || k <= 0) {
            return null;
        }
        int left = 0;
        int right = a.length - 1;
        int index = Partition(a, left, right);
        while (index != k - 1) {
            if (index > k - 1) {
                index = Partition(a, left, index - 1);
            } else {
                index = Partition(a, index + 1, right);
            }
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = a[i];
            System.out.println(a[i]);
        }
        return b;
    }

    private static int Partition(int[] a, int left, int right) {
        int pivot = a[left];
        while (left < right) {
            while (left < right && a[right] >= pivot) {
                right--;
            }
            if (left < right) {
                a[left++] = a[right];
            }
            while (left < right && a[left] <= pivot) {
                left++;
            }
            if (left < right) {
                a[right--] = a[left];
            }
        }
        a[left] = pivot;
        return left;
    }


//    public static void main(String[] args) {
//        int[] a = {34,2,56,234,45,72,46,756,23,54,3,6,23,54,24,5,14};
//        TopKmin topKmin = new TopKmin();
//        topKmin.topKmin(a, 17);
//    }




//    public static void main(String[] args) {
//        /**
//         * start    使用小顶堆找TOPK
//         * 时间复杂度为 O( n * log(k) ),空间复杂度为O( 1 )
//         */
//        int k = 18;//从1开始
//        int[] arr = new int[]{34,2,56,234,45,72,46,756,23,54,3,6,23,54,24,5,14};
//        Integer i = heapSortTopK(arr, k);
//        System.out.println("第" + k + "大元素为" + (i == null ? "null" : arr[i]));
//        //end    使用小顶堆找TOPK
//    }

    /**
     * 使用小顶堆寻找数组中的topK
     */
    private static Integer heapSortTopK(int[] arr, int k) {
        if (k > arr.length || k <= 0) {
            return null;
        }
        //在原数组上构建小顶堆
        builderHeap(arr, k);
        //比小顶堆堆顶元素大的数组元素，进入小顶堆
        for (int i = k; i < arr.length; i++) {
            //修改堆顶元素为当前数组中的元素
            if (arr[i] > arr[0]) {
                arr[0] = arr[i];
                downAdjust(arr, 0, k);
            }
        }
        return 0;
    }

    /**
     * 在数组中构建长为k的小顶堆
     */
    private static void builderHeap(int[] arr, int k) {
        //从最后一个非叶子节点调整，下沉元素
        for (int i = (k - 1) / 2; i >= 0; i--) {
            downAdjust(arr, i, k);
        }
    }

    /**
     * 循环下沉给定的parentIndex节点
     */
    private static void downAdjust(int[] arr, int parentIndex, int k) {
        //避免交换变量
        int temp = arr[parentIndex];
        int childIndex = parentIndex * 2 + 1;

        //下沉parentIndex
        while (childIndex < k) {
            //在数组长度范围内，拿到最小的孩子节点
            if (childIndex + 1 < k && arr[childIndex] > arr[childIndex + 1]) {
                childIndex++;
            }
            //此处需要注意：1.父节点小于子节点，则证明不用下沉 2.跳出后续父子节点索引修改的操作，避免最后赋值（temp）的一步产生出错
            if (temp < arr[childIndex]) {
                //此处表示该节点已经不需要下沉了
                break;
            }
            //上浮子节点(因父节点已经被记录，则只需要赋值到父即可)，更新父子节点的索引
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex * 2 + 1;
        }
        arr[parentIndex] = temp;
    }











}
