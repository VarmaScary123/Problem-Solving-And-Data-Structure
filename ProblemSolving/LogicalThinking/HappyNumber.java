/*
    Write an algorithm to determine if a number n is happy.

    A happy number is a number defined by the following process:

    Starting with any positive integer, replace the number by the sum of the squares of its digits.
    Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
    Those numbers for which this process ends in 1 are happy.
    Return true if n is a happy number, and false if not.

    

    Example 1:

    Input: n = 19
    Output: true
    Explanation:
    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
    Example 2:

    Input: n = 2
    Output: false
    

    Constraints:

    1 <= n <= 231 - 1
 */
package LogicalThinking;

import java.util.Scanner;

public class HappyNumber {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(isHappyNumber(N));
        sc.close();
    }

    public static boolean isHappyNumber(int N) {
        int slow = N, fast = N;

        do {
            slow = sumSquare(slow);
            fast = sumSquare(sumSquare(fast));

        } while(slow != fast);

        return slow == 1;
    }

    public static int sumSquare(int N) {
        int sum = 0;
        while(N > 0) {
            int k = N % 10;
            sum += k * k;
            N /= 10;
        }

        return sum;
    }
}
