package LogicalThinking;

import java.util.Arrays;
import java.util.Scanner;

public class DailyTemperatures {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int temperatures[] = new int[N];
        for(int i=0;i<N;i++)
            temperatures[i] = sc.nextInt();
        
        System.out.println(Arrays.toString(numberOfDays(temperatures)));
        sc.close();
    }

    public static int[] numberOfDays(int[] temperatures) {
        int ans[] = new int[temperatures.length];
        int max = 0;
        for(int i = temperatures.length - 1;i>=0;i--) {
            if(temperatures[i] >= max) {
                max = temperatures[i];
                continue;
            }

            int days = 1;
            while(temperatures[i+days] <= temperatures[i]) {
                days = days + ans[i+days];
            }

            ans[i] = days;
        }

        return ans;
    }
}
