package DataStructures.SortingAlgorithms;

import java.util.*;

public class QuickSort {
    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[l], i = l + 1, j = h;

        while (i <= j) {
            while (i <= j && arr[i] < pivot) {
                i++;
            }
            while (i <= j && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;
        System.out.println(Arrays.toString(arr));
        return j;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivotPos = partition(arr, l, h);

            quickSort(arr, l, pivotPos);
            quickSort(arr, pivotPos + 1, h);
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        quickSort(arr, 0, N - 1);
        System.out.println(Arrays.toString(arr));
        sc.close();
    }
}