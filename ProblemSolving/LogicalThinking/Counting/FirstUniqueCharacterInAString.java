package LogicalThinking.Counting;

/*
387. First Unique Character in a String

Given a string s, find the first non-repeating character in it and return its index. 
If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
 */

public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int N = s.length();
        int[] count = new int[26];
        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        for (int i = 0; i < N; i++) {
            if (count[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
}
