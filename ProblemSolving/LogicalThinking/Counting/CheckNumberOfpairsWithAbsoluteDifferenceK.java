package LogicalThinking.Counting;

/*
2006. Count Number of Pairs With Absolute Difference K

Given an integer array nums and an integer k, return the number of pairs (i, j) where i < j such that |nums[i] - nums[j]| == k.
The value of |x| is defined as:
x if x >= 0.
-x if x < 0.

Example 1:
Input: nums = [1,2,2,1], k = 1
Output: 4

Example 2:
Input: nums = [1,3], k = 3
Output: 0
Explanation: There are no pairs with an absolute difference of 3.

Example 3:
Input: nums = [3,2,1,5,4], k = 2
Output: 3

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
1 <= k <= 99
 */

public class CheckNumberOfpairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++)
                if(Math.abs(nums[j] - nums[i]) == k)
                    count++;
        }

        return count;
    }
}
