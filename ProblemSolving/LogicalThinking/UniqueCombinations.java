package LogicalThinking;

import java.util.*;
public class UniqueCombinations {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt(), arr[] = new int[N];
            for(int i=0;i<N;i++) arr[i] = sc.nextInt();

            int target = sc.nextInt();

            List<List<Integer>> result = getCombinations(arr, target);
            result.forEach(System.out::println);
        }

        sc.close();
    }

    public static List<List<Integer>> getCombinations(int[] arr, int T) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        getCombinationsHelper(result, new ArrayList<>(), arr, 0, T);

        return result;
    }

    public static void getCombinationsHelper(List<List<Integer>> result, List<Integer> currentList, int[] arr, int start, int T) {
        if(T == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int i=start;i<arr.length;i++) {
            if(i > start && arr[i] == arr[i-1])
                continue;

            if(arr[i] > T) break;

            currentList.add(arr[i]);
            getCombinationsHelper(result, currentList, arr, i+1, T-arr[i]);
            currentList.remove(currentList.size() - 1);
        }
    }
}