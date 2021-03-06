package com.xujm.leetcode;

/**
 * 参考https://blog.csdn.net/hk2291976/article/details/51107778
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * nums1 = [1, 3] nums2 = [2] 则中位数是 2.0
 * nums1 = [1, 2] nums2 = [3, 4] 则中位数是 (2 + 3)/2 = 2.5
 *
 * @author xujm
 * @date 2019/01/02
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            n = m;
            m = nums2.length;
        }
        int l1 = 0, r1 = 0, l2 = 0, r2 = 0, c1 = 0, c2 = 0, lo = 0;
        int h = 2 * n;
        while (lo <= h) {
            c1 = (lo + h) / 2;
            c2 = m + n - c1;
            l1 = (c1 == 0) ? Integer.MIN_VALUE : nums1[(c1 - 1) / 2];
            r1 = (c1 == 2 * n) ? Integer.MAX_VALUE : nums1[c1 / 2];
            l2 = (c2 == 0) ? Integer.MIN_VALUE : nums2[(c2 - 1) / 2];
            r2 = (c2 == 2 * m) ? Integer.MAX_VALUE : nums2[c2 / 2];
            if (l1 > r2) {
                h = c1 - 1;
            } else if (l2 > r1) {
                lo = c1 + 1;
            } else {
                break;
            }
        }

        return (Math.max(l1, l2) + Math.min(r2, r1)) / 2f;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 3};
        nums2 = new int[]{2, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

        nums1 = new int[]{1, 2};
        nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
