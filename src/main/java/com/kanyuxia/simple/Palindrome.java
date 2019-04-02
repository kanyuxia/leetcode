package com.kanyuxia.simple;

/**
 * 判断一个整数是否是回文数
 *
 * @author MaYing
 * @date 2019/4/1
 */
public class Palindrome {

    public static void main(String[] args) {
        int x = 121;
        boolean palindrome = CustomSolution.isPalindrome(x);
        System.out.println(palindrome);
    }

    /**
     * 自己的解题
     */
    static class CustomSolution {

        static boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0) {
                return false;
            }
            char[] chars = String.valueOf(x).toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                if (chars[i] != chars[chars.length - i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution {

        static boolean isPalindrome(int x) {
            if (x == 0) {
                return true;
            }
            if (x < 0) {
                return false;
            }
            if (x % 10 == 0) {
                return false;
            }
            int tmp = 0;
            while (x > tmp) {
                tmp = tmp * 10 + x % 10;
                x = x / 10;
            }
            return tmp == x || tmp / 10 == x;
        }
    }
}
