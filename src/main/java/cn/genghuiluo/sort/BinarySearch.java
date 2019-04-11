package cn.genghuiluo.sort;

/*
* 二分查找法
* 时间复杂度为O(logn)
*
* 缺陷:
* 1. 必须有序，我们很难保证我们的数组都是有序的。
* 2. 当然可以在构建数组的时候进行排序，可是又落到了第二个瓶颈上：它必须是数组。
*   数组读取效率是O(1)，可是它的插入和删除某个元素的效率却是O(n)。因而导致构建有序数组变成低效的事情。
*
* 解决这些缺陷问题更好的方法应该是使用二叉查找树了，最好自然是自平衡二叉查找树了，
* 既能高效的（O(n log n)）构建有序元素集合，又能如同二分查找法一样快速（O(log n)）的搜寻目标数
*
* https://juejin.im/post/5b15ff73e51d4506b113d956
* */
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 5, 9, 18 };
        BinarySearch bs = new BinarySearch();
        int search = 18;
        System.out.println(String.format("the index of '%s' in %s is: %s",
                String.valueOf(search),
                Arrays.toString(numbers),
                String.valueOf(bs.binarySearch(numbers, 18))));
        System.out.println(String.format("[without-recursion] the index of '%s' in %s is: %s",
                String.valueOf(search),
                Arrays.toString(numbers),
                String.valueOf(bs.binarySearch(numbers, 18))));

    }

    public int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    // recursion
    private int binarySearch(int[] array, int target, int low, int high) {
        if (low > high) { return -1; }

        int mid = low + (high - low) / 2;
        if (array[mid] > target) {
            return binarySearch(array, target, low, mid - 1);
        } else if (array[mid] < target){
            return binarySearch(array, target, mid + 1, high);
        } else {
            return mid;
        }
    }

    // loop
    public int binarySearchWithoutRecursion(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target){
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
