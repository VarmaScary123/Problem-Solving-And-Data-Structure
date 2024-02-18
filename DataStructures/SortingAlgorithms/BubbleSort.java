import java.util.*;
public class BubbleSort {
	public static void bubbleSort(int[] arr, int N) {
		boolean swapped = false;
		for(int i=0;i<N-1;i++) {
			for(int j=0;j<N-i-1;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}
			System.out.println(Arrays.toString(arr));
			if(!swapped) 
				break;
		}
	}
	
	public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), arr[] = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        bubbleSort(arr, N);
        System.out.println(Arrays.toString(arr));
        sc.close();
	}
}
