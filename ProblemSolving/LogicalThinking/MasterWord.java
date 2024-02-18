/*
    For a given word check if it is a MASTER word
    A master word is a word which follows the following rules:
    First character is not a digit
    Second character is not a vowel
    Next there is a number which could be one or more digits (NUM1)
    Next is one or more upper case VOWELS
    Next is a number which has one more digits (NUM2)
    Last character is a [ or { or } or ]

    If it matches the above rules print
    YES followed by NUM1+NUM2

    If it does not match any of the above rules print
    NO followed by NUM1-NUM2
*/

import java.util.*;

public class MasterWord {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        boolean b = s.matches("[A-Z]{1}[^AEIOU]{1}\\d+[AEIOU]{1,}\\d+[\\[\\]{}]");
        if (Character.isDigit(s.charAt(0)))
            s = s.substring(1);

        s = s.replaceAll("[^0-9\\s+]", " ").replaceAll("\\s+", " ").trim();
        int num1 = 0, num2 = 0;
        String s1[] = s.split("\\s+");
        if (s.isEmpty()) {
            System.out.println("NO " + (num1 - num2));
        } else if (b) {
            System.out.println("YES " + (Integer.parseInt(s1[0]) + Integer.parseInt(s1[1])));
        } else {
            System.out.println("NO " + (Integer.parseInt(s1[0]) - Integer.parseInt(s1[1])));
        }
        sc.close();
    }
}

