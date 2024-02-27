import java.util.*;

public class NoOfWaysForCoinDenomination {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int coins[] = new int[N];
        for(int i=0;i<N;i++)
            coins[i] = sc.nextInt();

        int amount = sc.nextInt();
        System.out.println("Number of Ways to Denominate the Amount : "+noOfWaysForCoinDenomination(coins, N, amount));
        sc.close();
    }

    public static int noOfWaysForCoinDenomination(int coins[], int N, int amount) {
        int dp[][] = new int[N][amount+1];
        for(int i=0;i<N;i++) {
            dp[i][0] = 1;
            for(int j=1;j<amount+1;j++) {
                if(i > 0)
                    dp[i][j] = dp[i-1][j];
                if(coins[i] <= j) {
                    dp[i][j] += dp[i][j - coins[i]];
                }
            }
        }
        // for(int i=0;i<dp.length;i++)
        //     System.out.println(Arrays.toString(dp[i]));
        return dp[N-1][amount]; 
    }
}
