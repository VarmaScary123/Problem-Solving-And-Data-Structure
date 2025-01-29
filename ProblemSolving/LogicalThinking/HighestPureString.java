package LogicalThinking;

import java.util.Scanner;

public class HighestPureString {

    // Method to check if a character is a vowel
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // Main method
    public static void main(String[] args) {
        // Input handling
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        
        int maxLength = 0; // To store the maximum length of pure string
        int currentLength = 0; // To store the current length of vowel substring

        // Traverse the string to find pure vowel substrings
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength); 
            } else {
                currentLength = 0;
            }
        }

        System.out.println(maxLength);
    }
}
