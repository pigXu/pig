package com.xujm.leetcode;

/**
 * 最长回文子串
 * 回文是一个正读和反读都相同的字符串
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * 输入: "cbbd" 输出: "bb"
 *
 * @author xujm
 * @date 2019/03/11
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    /**
     * 中心扩展算法
     *
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        if (null == s || s.length() < 1) {
            return s;
        }
        String result = s.substring(0, 1);
        return result;
    }

    /**
     * 暴力解法 时间复杂度：O(n^3)
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 1) {
            return s;
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                boolean isReverse = true;
                for (int n = i, m = j; n <= j; n++, m--) {
                    if (s.charAt(n) != s.charAt(m)) {
                        isReverse = false;
                        break;
                    }
                }
                if (isReverse) {
                    if (result.length() < (j - i + 1)) {
                        result = sub;
                    }
                }
            }
        }
        return result;
    }
}
