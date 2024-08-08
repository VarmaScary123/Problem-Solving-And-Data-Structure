package Backtracking;

import java.util.Scanner;

public class MazeLevel1 {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] sol = new int[N][N];
        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) 
                arr[i][j] = sc.nextInt();

        sc.close();
        if(findSolution(0, 0, arr, sol, N)) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++)
                    System.out.print(sol[i][j] + " ");
                System.out.println();
            }
        }
    }

    public static boolean findSolution(int i, int j, int[][] arr, int[][] sol, int N) {
        if(i==N-1 && j==N-1 && arr[i][j] == 0) {
            sol[i][j] = 1;
            return true;
        }

        if(i>=0 && i<N && j>=0 && j<N && arr[i][j] == 0) {
            sol[i][j] = 1;
            if(findSolution(i+1, j, arr, sol, N)) return true;
            if(findSolution(i, j+1, arr, sol, N)) return true;

            sol[i][j] = 0;
            return false;
        }

        return false;
    }
}
