package cn.genghuiluo.sort;

import java.util.Arrays;

/*
* https://www.cnblogs.com/chengxiao/p/6104371.html
* 希尔排序: 也称递减增量排序算法，是插入排序的一种更高效的改进版本。希尔排序是非稳定排序算法。
*
* 时间复杂度为: O(n3/2) 或 O(n4/3)
* */
public class ShellSort {

    public static void main(String[] args) {
        int[] numbers = {1, 11, 6, 5, 3, 8, 9};
        ShellSort ss = new ShellSort();
        System.out.println("before: " + Arrays.toString(numbers));
        System.out.println("after: " + Arrays.toString(ss.shellSort(numbers)));
    }

    int[] shellSort(int[] array) {
        int len = array.length;

        for (int gap = len / 2; gap > 0; gap /= 2) { // increment sequence
            for (int i = gap; i < len; i++) {
                int temp = array[i];
                int j = i - gap;
                for (; j >= 0 && array[j] > temp; j -= gap) {
                    // all elements which large than temp will move back the gap(not 1 like "insertion sort") position
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
        }

        return array;
    }

}
