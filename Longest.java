//Time = O(n^2), length of input string
//Space = O(1)

class Solution {
    public String longestPalindrome(String s) {
        // Check if the input string is null or empty
        if (s == null || s.length() == 0) {
            return "";
        }
        
        // Get the length of the input string
        int n = s.length();
        // Initialize variables to keep track of the maximum length palindrome and its starting index
        int maxLen = 0;
        int start = 0;
        
        // Iterate through each character in the string
        for (int i = 0; i < n; i++) {
            // Check palindromes with odd length centered at i
            int len1 = expandFromCenter(s, i, i);
            // Check palindromes with even length centered at i and i+1
            int len2 = expandFromCenter(s, i, i+1);
            
            // Get the maximum length palindrome centered at i
            int len = Math.max(len1, len2);
            // If the current palindrome is longer than the maximum seen so far, update maxLen and start index
            if (len > maxLen) {
                maxLen = len;
                start = i - (len - 1) / 2;
            }
        }
        
        // Return the longest palindrome substring
        return s.substring(start, start + maxLen);
    }
    
    // Helper function to expand the palindrome from the center
    private int expandFromCenter(String s, int left, int right) {
        // Iterate outwards from the center and check if the characters match
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // If the characters match, expand the palindrome by moving the left pointer left and the right pointer right
            left--;
            right++;
        }
        // Return the length of the palindrome
        return right - left - 1;
    }
}
