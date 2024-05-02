package LogicalThinking;

import java.util.HashMap;
import java.util.Scanner;

public class SubArraySumEqualsK {
    public static void main(String ar[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(), arr[] = new int[N];

        for(int i=0;i<N;i++) arr[i] = sc.nextInt();

        int k = sc.nextInt();

        System.out.println(subArraySumEqualsK(arr, N, k));
        sc.close();
    }

    public static int subArraySumEqualsK(int[] arr, int N, int k) {
        int sum = 0, count = 0;

        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        for(int i=0;i<N;i++) {
            sum += arr[i];
            if(map.containsKey(sum - k)) count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
