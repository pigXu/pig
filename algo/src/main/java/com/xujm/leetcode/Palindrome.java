package com.xujm.leetcode;

/**
 * 回文数 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 输入: 121 输出: true
 * 输入: 1212 输出: false
 */
public class Palindrome {
    /**
     * 反转一半对比
     * 时间复杂度O(log n)
     * 空间复杂度O(1)
     */
    public static boolean isPalindrome(int x) {
        if (0 == x) {
            return true;
        }
        if (x < 0 || 0 == x % 10) {
            return false;
        }
        int r = 0;
        while (x > r) {
            r = r * 10 + x % 10;
            x = x / 10;
        }

        //偶数||奇数
        return r == x || x == r / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1212));
        System.out.println(isPalindrome(10));
    }
}
