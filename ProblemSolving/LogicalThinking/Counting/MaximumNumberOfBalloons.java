package LogicalThinking.Counting;

import java.util.Arrays;

/*
1189. Maximum Number of Balloons

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only
 */

public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        // Map<Character, Integer> textFreq = new HashMap<>();
        // for(char ch : text.toCharArray())
        //     textFreq.put(ch, textFreq.getOrDefault(ch, 0)+1);

        // char ch[] = {'b', 'a', 'l', 'o', 'n'};
        // int max = Integer.MAX_VALUE;
        // for(char c : ch) {
        //     if(textFreq.containsKey(c)) {
        //         if(c == 'l' || c == 'o') {
        //             // if(textFreq.get(c) >= 2)
        //                 max = Math.min(max, textFreq.get(c)/2);
        //         } else {
        //             max = Math.min(max, textFreq.get(c));
        //         }
        //     } else {
        //         return 0;
        //     }
        // }

        // return max;

        int[] arr = new int[5];

        for(int i=0;i<text.length();i++) {
            if(text.charAt(i) == 'b')
                arr[0]++;
            else if(text.charAt(i) == 'a')
                arr[1]++;
            else if(text.charAt(i) == 'l')
                arr[2]++;
            else if(text.charAt(i) == 'o')
                arr[3]++;
            else if(text.charAt(i) == 'n')
                arr[4]++;
        }

        arr[2] /= 2;
        arr[3] /= 2;

        return Arrays.stream(arr).min().getAsInt();
    }
}
