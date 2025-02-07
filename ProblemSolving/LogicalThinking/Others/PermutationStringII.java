package LogicalThinking.Others;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PermutationStringII {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

        System.out.println(checkInClusion(s1, s2));
        sc.close();
    }

    public static boolean checkInClusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        for(char ch : s1.toCharArray()) 
            s1Count.put(ch, s1Count.getOrDefault(ch, 0) + 1);

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0, required = s1Count.size(), formed = 0;

        while(right < s2.length()) {
            char rightChar = s2.charAt(right);
            windowCount.put(rightChar, windowCount.getOrDefault(rightChar, 0) + 1);

            if(s1Count.containsKey(rightChar) && windowCount.get(rightChar).equals(s1Count.get(rightChar)))
                formed ++;

            while(left <= right && formed == required) {
                if(right - left + 1 == s1.length())
                    return true;
                char leftChar = s2.charAt(left);
                windowCount.put(leftChar, windowCount.get(leftChar) - 1);
                if(s1Count.containsKey(leftChar) && windowCount.get(leftChar).compareTo(s1Count.get(leftChar)) < 0)
                    formed--;
                left++;
            }
            right++;
        }
        return false;
    }
}
