import java.util.*;

public class InsertionSort {
    public static void insertionSort(int[] arr, int N) {
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        insertionSort(arr, N);
        sc.close();
        System.out.println(Arrays.toString(arr));
    }
}