package LogicalThinking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pascaltriangle {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> triangle = pascalTriangle(n);
        System.out.println(triangle);
        sc.close();
    }

    public static List<List<Integer>> pascalTriangle(int N) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<Integer> row = new ArrayList<>();
            int number = 1;

            for(int j=0;j<=i;j++) {
                row.add(number);

                number = number * (i-j)/(j+1);
            }
            triangle.add(row);
        }
        return triangle;
    }
}
