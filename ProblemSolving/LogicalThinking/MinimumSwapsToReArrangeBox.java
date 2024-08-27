package LogicalThinking;

import java.util.*;
public class MinimumSwapsToReArrangeBox {

    public static void main(String rg[]) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int rightMostR[] = new int[N];

        for(int i=0;i<N;i++) {
            String s = sc.nextLine();
            rightMostR[i] = -1;
            for(int j=0;j<N;j++) {
                if(s.charAt(j) == 'R') 
                    rightMostR[i] = j; 
            }
        }

        sc.close();

        int swaps = 0;
        for(int i=0;i<N;i++) {
            if(rightMostR[i] > i) {
                int j = i+1;
                while(j < N && rightMostR[j] > i) {
                    j++;
                }

                if(j == N) {
                    System.out.println("-1");
                    return;
                }

                while(j > i) {
                    int temp = rightMostR[j];
                    rightMostR[j] = rightMostR[j-1];
                    rightMostR[j-1] = temp;
                    swaps++;
                    j--;
                }
            }
        }

        System.out.println(swaps);
    }
}
