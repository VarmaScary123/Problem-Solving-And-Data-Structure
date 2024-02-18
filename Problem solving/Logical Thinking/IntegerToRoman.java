/*
    Convert a Given Number into its Respetve Roman Letter 
    Example : 
        Input:  1
                20
        Output: XX
*/


import java.util.*;
public class IntegerToRoman {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int num[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String sm[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        while(T-- > 0) {
            int N = sc.nextInt();
            if(N>10000) {
                System.out.println("Invalid");
            } else {
                StringBuilder sb = new StringBuilder();
                for(int i=0;i<num.length;i++) {
                    while(N >= num[i]) {
                        N -= num[i];
                        sb.append(sm[i]);
                    }
                }
                System.out.println(sb.toString());
            }
        }
        sc.close();
    }
}