/*
    Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

    The following rules define a valid string:

    Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    Any right parenthesis ')' must have a corresponding left parenthesis '('.
    Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
    

    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "(*)"
    Output: true
    Example 3:

    Input: s = "(*))"
    Output: true
    

    Constraints:

    1 <= s.length <= 100
    s[i] is '(', ')' or '*'.
 */
package LogicalThinking.Others;

import java.util.Scanner;

public class ValidParenthesisString {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(validParenthesisString(s));
        sc.close();
    }

    public static boolean validParenthesisString(String s) {
        int min = 0, max = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') {
                min++;
                max++;
            } else if(c == ')') {
                min--;
                max--;
            } else {
                min--;
                max++;
            }
        }

        if(max < 0) return false;
        if(min < 0) min = 0;

        return min == 0;
    }
}
