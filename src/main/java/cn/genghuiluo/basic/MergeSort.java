package cn.genghuiluo.basic;

/*
* 归并排序的思想是：利用分治法，将一个数组分成两个子数组，对每个子数组分别排序，然后将排序好的子数组合并。
*
* 时间复杂度：O(nlogn)
*
* */

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] numbers = {9, 0, 1, 3, 4, 5, 2, 9, 8, 7, 6, 5, 9, 1, 0, 9};
        MergeSort ms = new MergeSort();
        System.out.println("before: " + Arrays.toString(numbers));
        ms.mergeSort(numbers);
        System.out.println("after: " + Arrays.toString(numbers));
    }

    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int low, int high) {
        if (low >= high) { // StackOverflowError
            return;
        } else {
            int middle = ( low + high ) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    private void merge(int[] array, int low, int middle, int high) {
        int[] assistArray = array.clone(); // 辅助数组
        int i = low;
        int j = middle + 1;

        for (int k = low; k <= high; k ++) {
            if (i > middle) {
                array[k] = assistArray[j ++];
            } else if (j > high) {
                array[k] = assistArray[i ++];
            } else if (assistArray[i] > assistArray[j]) {
                array[k] = assistArray[j ++];
            } else {
                array[k] = assistArray[i ++];
            }
        }
    }

}
