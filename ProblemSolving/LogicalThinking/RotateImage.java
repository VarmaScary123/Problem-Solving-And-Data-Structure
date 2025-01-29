package LogicalThinking;

import java.util.*;
public class RotateImage {
    public static void main(String argp[]) {
        Scanner sc = new Scanner(System.in);
        int N = 4;
        int[][] matrix = new int[][] {{1, 2, 3, 4},
                                    {5, 6, 7, 8},
                                    {9, 10, 11, 12},
                                {13, 14, 15, 16}};

        for(int i=0;i<N;i++) {
            for(int j=i+1;j<N;j++) {
                int temp = matrix[i][j];
                // System.out.println(temp);
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }
        
        for(int i=0;i<N;i++) {
            int k= N-1;
            for(int j=0;j<N/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = temp;
                k--;
            }
        }
        main(matrix, N);


        sc.close();
    }

    public static void main(int[][] matrix, int N) {
        for(int i=0;i<N;i++)
            System.out.println(Arrays.toString(matrix[i]));
    }
}
