package Backtracking;

import java.util.Scanner;

/*
 * Maze In Two Direction 
 * 
 * There is a given maze of size N x N[Basically a 2D Matrix]. The Source and the dstination location is top-left cell and
 * bottom right cell repectively. Some cells are valid to move and some cells are blocked. If one rat starts moving from start vertex, 
 * we have to find that is there any way to complete the path, if it is possible then mark the correct path for the rat.
 * 
 * The maze is Given as Binary Matrix, where it is marked with 0, it is a valid path, otherwise 1 for a blocked cel.
 * 
 * NOTE : The rat only movein two directions, Left to Right, Right to Left, Top to Bottom, Bottom to Top
 * 
 */

public class MazeLevel2 {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] sol = new int[N][N];
        for(int i=0;i<N;i++) 
            for(int j=0;j<N;j++)
                arr[i][j] =sc.nextInt();
        sc.close();
        
        if(findSolution(0, 0, arr, sol, N)) {
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    System.out.print(sol[i][j] +" ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No Solution Exists");
        }
    }

    public static boolean findSolution(int i, int j, int[][] arr, int[][] sol, int N) {
        if(i==N-1 && j==N-1 && arr[i][j] == 0) {
            sol[i][j] = 1;
            return true;
        }

        if(i>=0 && i<N && j>=0 && j<N && arr[i][j] == 0 && sol[i][j] == 0) {
            sol[i][j] = 1;
            if(findSolution(i+1, j, arr, sol, N)) return true;
            if(findSolution(i, j+1, arr, sol, N)) return true;
            if(findSolution(i-1, j, arr, sol, N)) return true;
            if(findSolution(i, j-1, arr, sol, N)) return true;

            sol[i][j] = 0;
            return false;
        }

        return false;
    }
}
