package com.kanyuxia.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MaYing
 * @date 2019/4/3
 */
public class RomanToInt {

    public static void main(String[] args) {
        String roman = "MCMXCIV";
        int value = Solution.romanToInt(roman);
        System.out.println(value);
    }

    static class CustomSolution {

        public static int romanToInt(String s) {
            Map<Character, Integer> map = new HashMap<>(7);
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
            char[] chars = s.toCharArray();
            int result = 0;
            for (int i = 0; i < chars.length; i++) {
                int value = map.get(chars[i]);
                result += value;
                if (i + 1 < chars.length) {
                    int nextValue = map.get(chars[i + 1]);
                    if (nextValue > value) {
                        result = result + nextValue - 2 * value;
                        i++;
                    }
                }
            }
            return result;
        }
    }

    static class Solution {
        public static int romanToInt(String s) {
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                int value = value(s.charAt(i));
                if (i + 1 < s.length() && value(s.charAt(i + 1)) > value) {
                    result -= value;
                } else {
                    result += value;
                }
            }
            return result;
        }

        private static int value(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return -1;
            }
        }
    }
}
