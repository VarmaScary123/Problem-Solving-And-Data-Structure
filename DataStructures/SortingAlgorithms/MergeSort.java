import java.util.*;

public class MergeSort {
    public static int[] mergeSort(int[] arr, int l, int m, int h) {
        int n1 = m - l + 1, n2 = h - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[m + 1 + i];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] < R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void merge(int arr[], int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            merge(arr, l, m);
            merge(arr, m + 1, h);

            mergeSort(arr, l, m, h);
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        merge(arr, 0, N - 1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}