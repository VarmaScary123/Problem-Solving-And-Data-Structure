package LogicalThinking.Others;

import java.util.Arrays;
import java.util.Scanner;

/*
 *  Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).

    Return the running sum of nums.

    Example 1:

    Input: nums = [1,2,3,4]
    Output: [1,3,6,10]
    Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    Example 2:

    Input: nums = [1,1,1,1,1]
    Output: [1,2,3,4,5]
    Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
    Example 3:

    Input: nums = [3,1,2,10,1]
    Output: [3,4,6,16,17]
    

    Constraints:

    1 <= nums.length <= 1000
    -10^6 <= nums[i] <= 10^6
 * 
 */

public class RunningSumOf1DArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i=0;i<N;i++) 
            nums[i] = sc.nextInt();

        System.out.println(Arrays.toString(runningSum(nums)));
        sc.close();
    }

    public static int[] runningSum(int[] nums) {
        int N = nums.length;
        int currentSum = 0;
        int[] result = new int[N];
        for(int i=0;i<N;i++) {
            currentSum += nums[i];
            result[i] = currentSum;
        }

        return result;
    }
}
