package cn.genghuiluo.leetcode;

/*
* https://leetcode.com/problems/two-sum/
* */

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        TwoSum ts = new TwoSum();
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i = 0; i < nums.length; i ++) {
            if (m.containsKey(nums[i])) {
                return new int[] { m.get(nums[i]), i};
            }
            m.put(target - nums[i], i);
        }

        throw new IllegalArgumentException("No Solution!");
    }
}
