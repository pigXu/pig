package com.xujm.leetcode;

import com.sun.tools.javac.util.Assert;

/**
 * 盛最多水问题 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水
 * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Assert.check(49 == maxArea(height));
        System.out.println("完成");
    }

    /**
     * 时间复杂度O(n)
     */
    public static int maxArea(int[] height) {
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            int res = 0;
            if (height[i] > height[j]) {
                res = height[j] * (j - i);
                j--;
            } else {
                res = height[i] * (j - i);
                i++;
            }
            if (max < res) {
                max = res;
            }
        }
        return max;
    }

    /**
     * 时间复杂度O(n2)
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int h = Math.min(height[i], height[j]);
                int area = h * (j - i);
                if (max < area) {
                    max = area;
                }
            }
        }
        return max;
    }
}
