package com.example;


// Question  - https://leetcode.com/problems/string-compression/
public class StringManipulation {

    public int compress(char[] chars) {
        int i = 0, res = 0;
        
        while (i < chars.length) {
            int groupLength = 1;
            
            // Count the length of each group of consecutive characters
            while (i + groupLength < chars.length && chars[i + groupLength] == chars[i]) {
                groupLength++;
            }
            
            // Add the character to the result position
            chars[res++] = chars[i];
            
            // If the group length is more than 1, add the count to the result position
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray()) {
                    chars[res++] = c;
                }
            }
            
            // Move to the next group of characters
            i += groupLength;
        }
        
        // Return the new length of the compressed array
        return res;
    }

}
