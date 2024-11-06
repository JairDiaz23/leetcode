package com.devstock.leetcode.exercises;

import java.util.HashSet;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 */
public class LongestSubstring {

    public static void main(String[] args) {
        final String s1 = "abcabcbb";
        final String s2 = "bbbbb";
        final String s3 = "pwwkew";
        final String s4 = " ";
        final String s5 = "au";
        int result = lengthOfLongestSubstring(s5);
        System.out.println(result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int left = 0; // Left pointer for the sliding window
        int maxLength = 0;

        // Expand the window by moving the right pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If duplicate character is found, move the left pointer to remove duplicates
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character to the set
            set.add(currentChar);

            // Update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
