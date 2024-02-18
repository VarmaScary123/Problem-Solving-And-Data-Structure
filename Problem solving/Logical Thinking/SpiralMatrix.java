/*
    Print the matrix in Spiral Manner for N*M matrix
 */

import java.util.*;
public class SpiralMatrix {
    
    public static void spiralMatrix(int[][] arr, int N, int M) {
        int row = 0, col = 0;

        while(row < N && col < M) {

            for(int i=col;i<M;i++) 
                System.out.print(arr[row][i]+" ");
            row++;

            for(int i=row;i<N;i++)
                System.out.print(arr[i][M-1]+" ");
            M--;

            if(row < N) {
                for(int i=M-1;i>=col;i--) 
                    System.out.print(arr[N-1][i]+" ");
                N--;
            }

            if(col < M) {
                for(int i=N-1;i>=row;i--) 
                    System.out.print(arr[i][col]+" ");
                col++;
            }

        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        int arr[][] = new int[N][M];
        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                arr[i][j] = sc.nextInt();
        spiralMatrix(arr, N, M);
        sc.close();
    }

}
