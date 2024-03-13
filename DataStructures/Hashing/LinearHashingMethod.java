/*
    Write an program to create a hash table to store and display 'n' number of elements using linear probing hashing method.
    The First line of the input is the no of elements 'n'. The Second line of the input is the insertion elements.
    
    Note: Size of the hash table is equal to no of elements 'n'.
 */

package DataStructures.Hashing;
import java.util.*;
public class LinearHashingMethod {
    public static void main(String asrg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        int hash[] = new int[N];
        Arrays.fill(hash, -1);
        sc.close();
        for(int i=0;i<N;i++) {
            int h1 = arr[i]%N;
            if(hash[h1]==-1)
                hash[h1] = arr[i];
            else {
                int j=1;
                while(hash[(h1 + j)%N]!=-1)
                    j++;
                hash[(h1 + j)%N] = arr[i];
            }
        }
        for(int i=0;i<N;i++)
            System.out.println("index "+i+" value = "+hash[i]);
    }
}