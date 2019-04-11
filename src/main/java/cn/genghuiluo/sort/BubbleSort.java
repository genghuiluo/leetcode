package cn.genghuiluo.sort;

import java.util.Arrays;

/*
* 冒泡排序: 是一种简单的排序算法。
* 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
* 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端
*
* 时间复杂度为: O(n^2)
* */

public class BubbleSort {

    public static void main(String[] args) {
        int[] numbers = {1, 11, 6, 5, 3, 8, 9};
        BubbleSort bs = new BubbleSort();
        System.out.println("before: " + Arrays.toString(numbers));
        System.out.println("after: " + Arrays.toString(bs.bubbleSort(numbers)));
    }

    int[] bubbleSort(int[] array) {
        int len = array.length;

        for (int i = 0; i < len - 1; i ++) {
            boolean swap = false;

            for (int j = 0; j < len - i - 1; j ++ ) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swap = true;
                }
            }

            if (! swap) {
                break;
            }
        }

        return array;
    }
}
