package com.kanyuxia.simple;


/**
 * 整数反转
 *
 * @author MaYing
 * @date 2019/3/27
 */
public class IntegerReverse {

    public static void main(String[] args) {
        int x = -214748364;
        int reverse = Solution.reverse(x);
        System.out.println(reverse);
    }

    /**
     * 自己的解题
     */
    static class CustomSolution {

        static int reverse(int x) {
            if (x == 0) {
                return 0;
            }
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            boolean positive = x >= 0;
            if (!positive) {
                x = -x;
            }
            String reverseStr = new StringBuilder(String.valueOf(x)).reverse().toString();
            long result = Long.valueOf(reverseStr);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            return (int) (positive ? result : -result);
        }
    }

    static class Solution {

        static int reverse(int x) {
            if (x == 0) {
                return x;
            }
            if (x == Integer.MIN_VALUE) {
                return 0;
            }
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x = x / 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                    return 0;
                }
                rev = 10 * rev + pop;
            }
            return rev;
        }
    }
}
