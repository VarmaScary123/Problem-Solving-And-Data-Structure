/*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

    

    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true
    

    Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
 */
package LogicalThinking.Others;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class IsomorphicString {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String t = sc.next();

        System.out.println(isIsomorphic(s, t));
        sc.close();
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length()!= t.length())
            return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i=0;i<s.length();i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if(map.containsKey(chS)) {
                if(map.get(chS) != chT) {
                    return false;
                }
            } else {
                if(map.containsValue(chT)) {
                    return false;
                }

                map.put(chS, chT);
            }
        }

        return true;
    }
}