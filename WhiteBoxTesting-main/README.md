# WhiteBoxTesting

This codebase contains the solution to a git manipulatiopn question - https://leetcode.com/problems/string-compression

## Question Description

Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

### Examples:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
Example 2:

Input: chars = ["a"]
Output: Return 1, and the first character of the input array should be: ["a"]
Explanation: The only group is "a", which remains uncompressed since it's a single character.
Example 3:

Input: chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output: Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
Explanation: The groups are "a" and "bbbbbbbbbbbb". This compresses to "ab12".
 

### Constraints:

1 <= chars.length <= 2000
chars[i] is a lowercase English letter, uppercase English letter, digit, or symbol.

## Solution approach 

1. Initialize Pointers and Result Counter:
 - i is used to traverse through the chars array.
 - res keeps track of the position in chars where we store the compressed result.
2. Traverse the Array:
 - Use a while loop to go through each character in chars and check for consecutive characters that form groups.
3. Count the Length of Each Group:
 - For each character at i, determine the length of the consecutive group starting at that character.
 - Use a nested while loop to count the length of this group by comparing each subsequent character to chars[i].
 - This length is stored in groupLength, representing the number of consecutive identical characters in the group.
4. Store the Character in the Result:
 - Write the current character (chars[i]) to the res position in chars, which will hold the compressed result.
5. Handle Group Lengths Greater Than 1:
 - If groupLength is greater than 1, convert groupLength to a string and store each digit as a character in the chars array starting from res.
 - For example, if groupLength is 12, 1 and 2 are stored as separate characters.
6. Move to the Next Group:
 - Increment i by groupLength to move to the next unique character in chars.
7. Return the Result Length:
 - After compressing all groups, return res, the new length of the compressed section of chars.
