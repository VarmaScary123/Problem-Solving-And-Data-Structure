package LogicalThinking;

/*
    Red and Green Balls You have a square grid (NxN). Each cell of the grid has either a red ball or a green ball. Your job is to arrange the balls in such a way that all the red balls are either on or below
    the main diagonal. The main diagonal starts from cell 1x1 and ends at cell NxN. You have only one move which is to swap adjacent rows. You need to achieve the final arrangement in minimal
    number of moves. If it is not possible to come to a resolution by swapping then print -1

    Input Format
    First line of input is the number of rows in grid. Rest are the lines in the grid
    Output Format
    Minimum number of moves

    Sample Input 1
    2
    
    RG
    RR

    Sample Output 1
    0

    Sample Input 2
    2
    
    GR
    RG

    Sample Output 2
    1
 */

import java.util.*;

public class MinimumSwapsToReArrangeBox {

    public static void main(String rg[]) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int rightMostR[] = new int[N];

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            rightMostR[i] = -1;
            for (int j = 0; j < N; j++) {
                if (s.charAt(j) == 'R')
                    rightMostR[i] = j;
            }
        }

        sc.close();

        int swaps = 0;
        for (int i = 0; i < N; i++) {
            if (rightMostR[i] > i) {
                int j = i + 1;
                while (j < N && rightMostR[j] > i) {
                    j++;
                }

                if (j == N) {
                    System.out.println("-1");
                    return;
                }

                while (j > i) {
                    int temp = rightMostR[j];
                    rightMostR[j] = rightMostR[j - 1];
                    rightMostR[j - 1] = temp;
                    swaps++;
                    j--;
                }
            }
        }

        System.out.println(swaps);
    }
}
