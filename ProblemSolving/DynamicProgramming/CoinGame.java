import java.util.Scanner;

public class CoinGame {

    public static int winner(int arr[], int n) {
        int table[][] = new int[n][n];
        for (int gap = 0; gap < n; ++gap) {
            for (int i = 0, j = gap; j < n; ++i, ++j) {
                int x = ((i + 2) <= j) ? table[i + 2][j] : 0;
                int y = ((i + 1) <= (j - 1)) ? table[i + 1][j - 1] : 0;
                int z = (i <= (j - 2)) ? table[i][j - 2] : 0;
                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return table[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
    
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
    
            System.out.println(winner(arr, n));
        }
        sc.close();
    }
}
