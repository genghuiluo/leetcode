package cn.genghuiluo.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(String.valueOf(lswrc.lengthOfLongestSubstring(s)));
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        int ans = 0;

        for (int j = 0, i = 0; j < s.length(); j ++) {
            if (m.containsKey(s.charAt(j))) {
                i = Math.max(m.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            m.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
