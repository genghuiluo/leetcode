package cn.genghuiluo.basic;

import java.util.Arrays;

/*
* 选择排序: 是一种简单直观的排序算法。它的工作原理如下。
* 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
*
* 选择排序是不稳定排序
* 时间复杂度为: O(n^2)
* */

public class SelectSort {

    public static void main(String[] args) {
        int[] numbers = {1, 11, 6, 5, 3, 8, 9};
        SelectSort ss = new SelectSort();
        System.out.println("before: " + Arrays.toString(numbers));
        System.out.println("after: " + Arrays.toString(ss.selectSort(numbers)));

    }

    int[] selectSort(int[] array) {
        int positon = 0;
        for (int i = 0; i < array.length; i ++) {
            int temp = array[i];
            int j = i + 1;
            for (; j < array.length; j ++) {
                if ( temp > array[j] ) {
                    temp = array[j];
                    positon = j;
                }
            }
            array[positon] = array[i];
            array[i] = temp;
        }
        return array;
    }
}
