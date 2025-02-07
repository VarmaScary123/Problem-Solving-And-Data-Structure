/*
    Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

    A subarray is a contiguous non-empty sequence of elements within an array.

    

    Example 1:

    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:

    Input: nums = [1,2,3], k = 3
    Output: 2
    

    Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
 */

package LogicalThinking.Others;

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
