package cn.genghuiluo.basic;

/*
* 快速排序是 java 默认的排序算法，其基本思想是：
* 1. 从数列中调出一个元素作为基准；
* 2. 对基准元素左侧与右侧分别扫描，将比基准元素小的放在基准元素左侧，大的放在右侧；
* 3. 基准元素左右两端得到了两个子数列，对子数列重复以上步骤。
*
* 时间复杂度：O(nlogn)
*
* https://github.com/joeyajames/Java/blob/master/QuickSort.java
* */

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] numbers = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        QuickSort qs = new QuickSort();
        System.out.println("before: " + Arrays.toString(numbers));
        qs.quickSort(numbers);
        System.out.println("after: " + Arrays.toString(numbers));
    }

    public void quickSort(int[] A) {
        quickSort(A, 0, A.length-1);
    }

    private void quickSort(int[] array, int low, int high) {
        if (low > high) {
            return;
        } else {
            int p = partition(array, low, high);
            quickSort(array, low, p-1);
            quickSort(array, p+1, high);
        }
    }

    private void swap(int[] array, int index1, int index2) {
        if (index1 != index2) { // 相同的index没有交换的意义
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
    }

    // returns random pivot index between low and high inclusive.
    private int getPivot(int low, int high) {
        Random rand = new Random();
        return rand.nextInt((high - low) + 1) + low; // 从 low~high 直接取随机 index, 也有 low+high/2 等其他做法
    }

    // moves all n < pivot to left of pivot and all n > pivot to right of pivot, then returns pivot index.
    private int partition(int[] array, int low, int high) {
        swap(array, low, getPivot(low, high)); // 将pivot的值swap到第一个, 方便从一侧扫描
        int border = low + 1; // 小于border的index, 它们的值都小于pivot的值
        for (int i = border; i <= high; i++) {
            if (array[i] < array[low]) {
                swap(array, i, border++);
            }
        }
        swap(array, low, border-1);
        return border-1;
    }

}
