package com.xujm.leetcode;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"] 输出: "fl"
 * 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(new String[]{"flower", "flow", "flight"})
        );
    }

    /**
     * 时间复杂度(On2)
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
            }
        }
        for (int i = 0; i < minLength; i++) {
            char a = strs[0].charAt(i);
            boolean eq = true;
            for (int j = 1; j < strs.length; j++) {
                eq = a == strs[j].charAt(i);
                if (!eq) {
                    break;
                }
            }
            if (!eq) {
                break;
            }
            sb.append(a);
        }
        return sb.toString();
    }
}
