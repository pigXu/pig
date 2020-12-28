package com.xujm.leetcode;

import java.util.*;

/**
 * 四数之和 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c
 * +d的值与 target 相等？找出所有满足条件且不重复的四元组。 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [
 * [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */
public class FourSum {
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

    /**
     * 时间复杂度O(n3)
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length < 4) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = nums.length - 1; j - i > 2; j--) {
                if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    continue;
                } else if (nums[i] + nums[j] + nums[j - 1] + nums[j - 2] < target) {
                    break;
                }
                int i1 = i + 1;
                int j1 = j - 1;
                while (i1 < j1) {
                    if (nums[i] + nums[j] + nums[i1] + nums[j1] == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[i1], nums[j1], nums[j]);
                        result.add(list);
                        j1--;
                    } else if (nums[i] + nums[j] + nums[i1] + nums[j1] < target) {
                        i1++;
                    } else if (nums[i] + nums[j] + nums[i1] + nums[j1] > target) {
                        j1--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * 时间复杂度O(n4)
     */
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                        if (nums[i1] + nums[i2] + nums[i3] + nums[i4] == target) {
                            List<Integer> list = Arrays.asList(nums[i1], nums[i2], nums[i3], nums[i4]);
                            list.sort(Integer::compare);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}