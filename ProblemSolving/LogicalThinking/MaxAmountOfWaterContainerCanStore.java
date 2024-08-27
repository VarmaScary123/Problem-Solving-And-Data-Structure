package LogicalThinking;

/*
    You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
import java.util.*;

public class MaxAmountOfWaterContainerCanStore {

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s[] = sc.nextLine().split(",");
        int arr[] = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i].trim());

        sc.close();

        int max = 0;
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(arr[right], arr[left]));

            if (arr[right] > arr[left])
                left++;
            else
                right--;
        }

        System.out.println(max);
    }
}
