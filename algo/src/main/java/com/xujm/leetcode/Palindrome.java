package com.xujm.leetcode;

/**
 * 回文数 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121 输出: true
 * 输入: 1212 输出: false
 */
public class Palindrome {
    /**
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     */
    public static boolean isPalindrome(int x) {
        try {
            return x == resverse(x);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static int resverse(int x) {
        int r = 0;
        while (x > 0) {
            r = r * 10 + x % 10;
            x = x / 10;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1212));
    }
}
