import java.util.*;

public class Sorting {

    public static void bubbleSort(int arr[], int N) {
        for (int i = 0; i < N - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swapped)
                break;
        }
    }

    public static void insertionSort(int[] arr, int N) {
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void selectionSort(int[] arr, int N) {
        for (int i = 0; i < N; i++) {
            int minInd = i;
            for (int j = i + 1; j < N; j++) {
                if (arr[j] < arr[minInd])
                    minInd = j;
            }

            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    public static void merge(int[] arr, int l, int m, int h) {
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
    }

    public static int partition(int[] arr, int l, int h) {
        int pivot = arr[h];
        int i = l - 1;
        for (int j = l; j < h; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[h];
        arr[h] = arr[i + 1];
        arr[i + 1] = temp;
        System.out.println(Arrays.toString(arr));

        return i + 1;
    }

    public static void quickSort(int[] arr, int l, int h) {
        if (l < h) {
            int pivotPos = partition(arr, l, h);

            quickSort(arr, l, pivotPos - 1);
            quickSort(arr, pivotPos + 1, h);
        }
    }

    public static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int mid = (l + h) / 2;

            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, h);

            merge(arr, l, mid, h);
        }
    }

    public static int[] countSort(int[] arr, int N) {
        int M = Arrays.stream(arr).max().getAsInt();
        int outputArr[] = new int[N];
        int countArr[] = new int[M + 1];

        for (int i = 0; i < N; i++) {
            countArr[arr[i]]++;
        }

        for (int i = 1; i <= M; i++)
            countArr[i] += countArr[i - 1];

        for (int i = N - 1; i >= 0; i--) {
            outputArr[countArr[arr[i]] - 1] = arr[i];
            countArr[arr[i]]--;
        }

        return outputArr;
    }

    public static void radixSort(int[] arr, int N) {
        int M = Arrays.stream(arr).max().getAsInt();
        for(int exp = 1; M/exp > 0 ; exp *=10) {

            countSort(arr, N, exp);
        }
    }

    public static void countSort(int[] arr, int N, int exp) {
        int outputArr[] = new int[N];
        int countArr[] = new int[10];

        for(int i=0;i<N;i++) 
            countArr[(arr[i]/exp) %10]++;

        for(int i=1;i<10;i++) {
            countArr[i] += countArr[i-1];
            System.out.println(Arrays.toString(countArr));
        }
        
        for(int i=N-1;i>=0;i--) {
            outputArr[countArr[(arr[i]/exp)%10] - 1] = arr[i];
            countArr[(arr[i]/exp)%10]--;
        }
        System.out.println(Arrays.toString(outputArr));
    }

    public static void main(String arg[]) {
        int N = 9;
        int arr[] = { 90, 80, 70, 60, 50, 40, 30, 20, 10 };

        // bubbleSort(arr, N);
        // insertionSort(arr, N);
        // selectionSort(arr, N);
        // mergeSort(arr, 0, N-1);
        // quickSort(arr, 0, N-1);
        // int res[] = countSort(arr, N);
        // System.out.println(Arrays.toString(res));
        radixSort(arr, N);
        
    }
}