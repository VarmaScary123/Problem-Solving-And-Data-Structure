import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
	public static void selectionSort(int[] arr, int N) {
		for(int i=0;i<N;i++) {
			int minInd = i;
			for(int j=i+1;j<N;j++) {
				if(arr[j] < arr[minInd])
					minInd = j;
			}
			int temp = arr[i];
			arr[i] = arr[minInd];
			arr[minInd] = temp;
		}
	}
	
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), arr[] = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        selectionSort(arr, N);
        System.out.println(Arrays.toString(arr));
        sc.close();
	}
}
