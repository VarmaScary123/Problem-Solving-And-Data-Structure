/*
    Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last
    index starting at index 0.
    Return True or False

    Input Format
    First line of the input is an integer N which is the number of points.
    Next N lines of input each contains integer representing the possible distance of jump from that point.
    Output Format
    Single line - "True" if able to reach the end of the array / "False" if not able to reach the end of the array.

    Constraints
    1 <= N <= 100

    0 <= arr[i] <= 10000

    Sample Input 1
    4
    2 0 1 0

    Sample Output 1
    True

    Sample Input 2
    4
    1 1 0 1

    Sample Output 2
    False
*/
package LogicalThinking.Others;
import java.util.*;
public class CanReachEnd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i=0;i<N;i++) arr[i] = sc.nextInt();
        sc.close();
        boolean isAtLast = canReachEnd(arr, N);

        System.out.println(isAtLast ? "True" : "False");
    }

    public static boolean canReachEnd(int[] arr, int N) {
        int farthestReach = 0;
        for(int i=0;i<N;i++) {
            if(farthestReach < i) return false;

            farthestReach = Math.max(farthestReach, i + arr[i]);

            if(farthestReach >= N-1) return true;
        }

        return false;
    }
}