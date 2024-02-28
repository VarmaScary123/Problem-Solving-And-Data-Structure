import java.util.*;

public class MinimumNumberOfCoinsRequired {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int coins[] = new int[N];
        for(int i = 0; i < N; i++) 
            coins[i] = sc.nextInt();

        int amount = sc.nextInt();
        System.out.println(minimumNumberOfCoinsRequired(coins, N, amount));
        sc.close();
    }    

    public static int minimumNumberOfCoinsRequired(int coins[], int N, int amount) {
        int dp[][] = new int[N][amount+1];
        
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = (j % coins[0] == 0) ? j / coins[0] : Integer.MAX_VALUE;
        }
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= amount; j++) {
                if(j < coins[i])
                    dp[i][j] = dp[i - 1][j];
                else  
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i]]);
            }
        }

        for(int i=0;i<dp.length;i++)
            System.out.println(Arrays.toString(dp[i]));
        return dp[N - 1][amount];
    }
}
