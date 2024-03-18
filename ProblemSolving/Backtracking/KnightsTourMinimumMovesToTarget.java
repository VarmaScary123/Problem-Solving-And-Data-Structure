/*
    Given a square chessboard of N x N size, the starting position of Knight and target position is given. We need to find out minimum steps
    a Knight will take to reach the target position. Knight moves in a L pattern - check the internet for how a knight moves on a chess board
    Sample Input

    1 1 
    8 8

    Sample Output
    6

    HINT: In chess, a knight can come to the same position through multiple ways - so this code could easily lead to infinite loops. You have
    to save the history of positions visited and check if the new position is unique.
 */

package Backtracking;

import java.util.Scanner;

public class KnightsTourMinimumMovesToTarget {
    
    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int N = 9;
    static int minMoves = Integer.MAX_VALUE;

    static boolean isValidMove(int X, int Y) {
        return (X >= 0 && X < N && Y >= 0 && Y < N);
    }

    static void findMinStep(int X, int Y, int targetX, int targetY, int moves, boolean[][] visited) {
        if(X == targetX && Y == targetY) {
            minMoves = Math.min(minMoves, moves);
            return;
        }

        if(moves >= minMoves) 
            return;

        visited[X][Y] = true;

        for(int i=0;i<8;i++) {
            int nextX = X + dx[i];
            int nextY = Y + dy[i];

            if(isValidMove(nextX, nextY) && !visited[nextX][nextY]) {
                findMinStep(nextX, nextY, targetX, targetY, moves + 1, visited);
            }
        }

        visited[X][Y] = false;

        return;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int startX = sc.nextInt(), startY = sc.nextInt();
        int targerX = sc.nextInt(), targetY = sc.nextInt();
        findMinStep(startX, startY, targerX, targetY, 0, new boolean[N][N]);
        
        sc.close();
        System.out.println(minMoves);
    }

}
