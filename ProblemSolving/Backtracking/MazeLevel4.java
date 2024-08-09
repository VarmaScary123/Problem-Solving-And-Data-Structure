package Backtracking;

import java.util.Scanner;

public class MazeLevel4 {

    static int shortestPath = Integer.MAX_VALUE;
    static int[][] bestSol;

/*
 * Maze In Two Direction 
 * 
 * There is a given maze of size N x N[Basically a 2D Matrix]. The Source and the dstination location is top-left cell and
 * bottom right cell repectively. Some cells are valid to move and some cells are blocked. If one rat starts moving from start vertex, 
 * we have to find that is there any way to complete the path, if it is possible then mark the correct path for the rat.
 * 
 * The maze is Given as Binary Matrix, where it is marked with 0, it is a valid path, otherwise 1 for a blocked cel.
 * 
 * NOTE : The rat only movein four directions, Left to Right, Right to Left, Top to Bottom, Bottom to Top with Shortest Path
 * with a starting location
 * 
 */
    public static void main(String arg[]) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int[][] arr = new int[N][N];
        int[][] sol = new int[N][N];
        for(int i=0;i<N;i++) 
            for(int j=0;j<N;j++)
                arr[i][j] = sc.nextInt();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        sc.close();

        bestSol = new int[N][N];
        findSolution(startX, startY, arr, sol, N, 0);

    }

    public static void findSolution(int i, int j, int[][] arr, int[][] sol, int N, int pathLength) {
        if((i==0 || i==N-1) && (j==0 || j==N-1) && arr[i][j] == 0) {
            sol[i][j] = 1;
            if(shortestPath > pathLength) {
                shortestPath = pathLength;
                copySolution(sol, bestSol, N);
                System.out.println("Minimum Steps : " + (shortestPath+1));
                display(bestSol, N);
            }
            sol[i][j] = 0;
            return;
        }
        if(i>=0 && i<N && j>=0 && j<N && arr[i][j] == 0 && sol[i][j] == 0) {
            sol[i][j] = 1;
            findSolution(i+1, j, arr, sol, N, pathLength+1);
            findSolution(i, j+1, arr, sol, N, pathLength+1);
            findSolution(i-1, j, arr, sol, N, pathLength+1);
            findSolution(i, j-1, arr, sol, N, pathLength+1);

            sol[i][j] = 0;
            return;
        }

        return;
    }

    public static void copySolution(int[][] from, int[][] to, int N) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                to[i][j] = from[i][j];
            }
        }
    }

    public static void display(int[][] sol, int N) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }
}
