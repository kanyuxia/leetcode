package com.kanyuxia.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数相加
 *
 * @author MaYing
 * @date 2019/2/13
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] result = OneTimeHashSolution.twoSum(nums, 9);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 自己的解题
     * 时间复杂度O(n^n)、空间复杂度O(1)
     */
    static class CustomSolution {
        public static int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }
            return result;
        }
    }

    /**
     * 两遍哈希表
     * 时间复杂度O(n)、空间复杂度O(n)
     */
    static class TwoTimeHashSolution {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int value = target - nums[i];
                if (map.containsKey(value) && map.get(value) != i) {
                    return new int[]{i, map.get(value)};
                }
            }
            throw new RuntimeException("no two sum solution");
        }
    }

    static class OneTimeHashSolution {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            for (int i = 0; i < nums.length; i++) {
                int value = target - nums[i];
                if (map.containsKey(value)) {
                    return new int[]{map.get(value), i};
                }
                map.put(nums[i], i);
            }
            throw new RuntimeException("no two sum solution");
        }
    }
}


