import java.util.*;
public class CanSum {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s[] = sc.next().replaceAll("[\\[\\]]", "").split(",");
        int[] arr = new int[s.length];

        sc.close();
        
        for(int i=0;i<s.length;i++)
            arr[i] = Integer.parseInt(s[i].trim());
            
        System.out.println(canSum(T, arr));
    }
    
    public static boolean canSum(int T, int[] arr) {
        boolean dp[] = new boolean[T+1];
        dp[0] = true;
        
        for(int i=0;i<=T;i++) {
            if(dp[i]) {
                for(int num : arr) {
                    if(i + num <= T) 
                        dp[i + num] = true;
                }
            }
        }
        
        return dp[T];
    }
}