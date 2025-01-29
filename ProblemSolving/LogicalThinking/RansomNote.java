package LogicalThinking;

/*
    Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

    Each letter in magazine can only be used once in ransomNote.

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
        Map<Character, Integer> magazineLetters = new HashMap<>();

        for(char ch : magazine.toCharArray()) 
            magazineLetters.put(ch, magazineLetters.getOrDefault(ch, 0) + 1);

        for(int i=0;i<ransomNote.length();i++) {
            char ch = ransomNote.charAt(i);
            int currentCount = magazineLetters.getOrDefault(ch, 0);

            if(currentCount == 0)
                return false;

            magazineLetters.put(ch, currentCount - 1);
        } 

        return true;
    }
}
