package com.xujm.leetcode;

import java.util.HashMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 输入: "abcabcbb" 输出: 3
 * 输入: "bbbbb" 输出: 1
 *
 * @author xujm
 * @date 2019/01/02
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>(s.length());
        while (j < s.length()) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(map.get(c), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(c, ++j);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbb"));
    }
}
