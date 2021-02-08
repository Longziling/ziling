package com.ziling.goodlife.algorithm;

public class QuickSort {

    public static void quickSort(int[] num, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            int x = num[l];
            while(i < j) {
                while (i < j && num[j] > x) {
                    j--;
                }
                if (i < j) {
                    num[i++] = num[j];
                }
                while (i < j && x > num[i]) {
                    i++;
                }
                if (i < j) {
                    num[j--] = num[i];
                }
            }
            num[i] = x;
            quickSort(num, l, i - 1);
            quickSort(num, i + 1, r);
        }
    }

    public static void print(int[] num) {
        for (int i : num) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] num = {34,23,6435,4234,2523,425235,234234,6345,23,54,43,23,23,43,53,2,423,6345,432,24,25,2,234,53,6546,5345,2342,63534,234,4364};
        print(num);
        quickSort(num, 0, num.length - 1);
        print(num);
    }


}
