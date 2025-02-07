package LogicalThinking.Counting;

/*
 383. Ransom Note
 Given two strings ransomNote and magazine, return true if ransomNote can be constructed by 
 using the letters from magazine and false otherwise

 Each letter in magazine can only be used once in ransomNote

 Example 1:
 Input: ransomNote = "a", magazine = "b"
 Output: false

 Example 2:
 Input: ransomNote = "aa", magazine = "ab"
 Output: false

 Example 3:
 Input: ransomNote = "aa", magazine = "aab"
 Output: true

 Constraints:

 1 <= ransomNote.length, magazine.length <= 105
 ransomNote and magazine consist of lowercase English letters.
 */

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<ransomNote.length();i++) {
            char ch = ransomNote.charAt(i);
            int count = map.getOrDefault(ch, 0);
            if(count == 0)
                return false;
            map.put(ch, map.get(ch) - 1);
        }

        return true;
    }
}
