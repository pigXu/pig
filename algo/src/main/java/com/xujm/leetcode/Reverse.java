package com.xujm.leetcode;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 */
public class Reverse {
    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {
        System.out.println(321 == reverse(123));
        System.out.println(-321 == reverse(-123));
        System.out.println(reverse(1534236469));
    }
}
