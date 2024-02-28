import java.util.*;
public class RodCutting {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(",\\s");
        int N = s.length;
        int prices[] = new int[s.length];
        // System.out.println(Arrays.toString(s));
        for(int i=0;i<N;i++) {
            String str = s[i].replaceAll("[^0-9]", "");
            prices[i] = Integer.parseInt(str);
        }
        
        System.out.println(maxObtainable(prices, N));
        sc.close();
    }
    
    public static int maxObtainable(int prices[], int N) {
        int dp[][] = new int[N+1][N+1];
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=N;j++) {
                if(i==0 || j==0)
                    dp[i][j] = 0;
                else {
                    if(i == 1) {
                        dp[i][j] = j* prices[i-1];
                    } else {
                        if(i > j) {
                            dp[i][j] = dp[i-1][j];
                        } else {
                            dp[i][j] = Math.max(prices[i-1] + dp[i][j - i], dp[i-1][j]);
                        }
                    }
                }
            }
        }
        return dp[N][N];
    }
}