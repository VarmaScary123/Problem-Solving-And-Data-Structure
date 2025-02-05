package LogicalThinking;
/*
 * You are given two strings s1 and s2 of equal length. 
 * A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. 
 * Otherwise, return false
 * 
 * Example 1:
 * Input: s1 = "bank", s2 = "kanb"
 * Output: true
 * Explanation: For example, swap the first character with the last character of s2 to make "bank".
 * 
 * Example 2:
 * Input: s1 = "attack", s2 = "defend"
 * Output: false
 * Explanation: It is impossible to make them equal with one string swap.
 * 
 * Constraints:
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 and s2 consist of only lowercase English letters.
 */

public class CheckIfOneStringSwapsCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        int firstIndex = 0;
        int secondIndex = 0;
        int numDiff = 0;

        for(int i=0;i<s1.length();i++) {
            char sch1 = s1.charAt(i);
            char sch2 = s2.charAt(i);

            if(sch1 != sch2) {
                numDiff++;

                if(numDiff > 2) return false;
                else if(numDiff == 1) {
                    firstIndex = i;
                } else {
                    secondIndex = i;
                }
            }
        }

        return s1.charAt(firstIndex) == s2.charAt(secondIndex) &&
            s1.charAt(secondIndex) == s2.charAt(firstIndex);
    }
}
