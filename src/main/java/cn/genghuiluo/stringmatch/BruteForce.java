package cn.genghuiluo.stringmatch;

/*
*  BF算法：暴力检索法
*  1. 原字符串和子串左端对齐，逐一比较；
*  2. 如果第一个字符不能匹配，则子串向后移动一位继续比较；
*  3. 如果第一个字符匹配，则继续比较后续字符，直至全部匹配。
*
* */


public class BruteForce {

    public static void main(String[] args) {
        String str = "abcdefg123";
        String pattern = "fg123";

        System.out.println(String.format("the index of '%s' in %s is: %s",
                pattern, str,
                String.valueOf(match(str,pattern))));

    }

    static int match(String str, String pattern) {
        int index = -1; // if not match, return
        int len = str.length() - pattern.length();
        boolean match = true;

        for (int i = 0; i <= len; i++) {
            match  = true;

            for (int j=0; j < pattern.length(); j++) {
                if (str.charAt(i + j) != pattern.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                index = i;
                break;
            }
        }

        return index;
    }

}
