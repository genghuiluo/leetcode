package cn.genghuiluo.sort;

import java.util.Arrays;

/*
* 时间复杂度： O(n^2)（注：时间复杂度一般考察算法的最坏情况时的时间代价）
* 插入排序是原地排序(sort in place)， 即在待排序的数组内部进行排序，不需要额外申请新的空间作临时容器
* 插入排序是稳定排序(stable sort)
*   所谓稳定排序是指待排序序列中有两个（或者两个以上）相等的元素：Ai=Aj，排序前i<j，若排序后仍然满足i<j，即相等元素排序前后的顺序并未改变，则称这种排序算法是稳定的
*
* 若数据用的是双向链表这种数据结构来存储，要实现对这个双向链表的排序，使用插入排序是一个不错的选择，因为链表这种数据结构若选择需要频繁交换的排序算法（如冒泡排序），代价极大
* */
public class InsertionSort {

    public static void main(String[] args) {
        int[] numbers = {6, 5, 3, 8};
        InsertionSort is = new InsertionSort();
        System.out.println("before: " + Arrays.toString(numbers));
        System.out.println("after: " + Arrays.toString(is.insertionSort(numbers)));
    }

    int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0 && array[j] > temp; j --) {
                // all elements which large than temp will move back 1 position
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
        return array;
    }
}
