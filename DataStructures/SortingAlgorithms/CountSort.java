import java.util.*;

public class CountSort {
    public static int[] countSort(int arr[], int N, int M) {
        int outputArr[] = new int[N];
        int countArr[] = new int[M + 1];

        for (int i = 0; i < N; i++)
            countArr[arr[i]]++;

        for (int i = 1; i <= M; i++)
            countArr[i] += countArr[i - 1];

        for (int i = N - 1; i >= 0; i--) {
            outputArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }

        return outputArr;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        int maxElement = Arrays.stream(arr).max().getAsInt();
        arr = countSort(arr, N, maxElement);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}
