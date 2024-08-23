package LogicalThinking;

import java.util.*;
public class PaintTheWalls {
    
    static int count = 0;
    
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().replaceAll("[\\[]", "").replaceAll("\"", "").split("],");
        int[][] arr = new int[s.length][];
        
        for(int i=0;i<s.length;i++) {
            String x[]= s[i].replaceAll("[\\]]", "").split(",");
            arr[i] = new int[x.length];
            
            for(int j=0;j<x.length;j++)
                arr[i][j] = Integer.parseInt(x[j].trim());
        }
        fillTheWalls(arr, sc.nextInt() - 1, sc.nextInt() - 1);
        
        System.out.println(count);

        sc.close();
    }
    
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, 1}, {1, -1}, {1, 1}, {-1, -1}};
    
    public static void fillTheWalls(int[][] arr, int N, int M) {
        
        if(N < 0 || N >= arr.length || M < 0 || M >= arr[0].length) return;
        
        if(arr[N][M] != 0) return;
        
        arr[N][M] = 2;
        count++;
        
        for(int[] dir : dirs) {
            fillTheWalls(arr, N + dir[0], M + dir[1]);
        }
        
    }
}