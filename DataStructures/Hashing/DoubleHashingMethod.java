/*
    Create an Hash table to store and display the number of elements 'n' using Double hashing method. The First line of the input is the the
    number of elements 'n'. The second line of the input is the insertion elements.

    Note:
        1. The size of the Hash table is equal to the number of elements .

        2. Use mod function for hashing.

    h1(x)=x % n

    In case of collision use

    h3(x) = (h1(x) + j*h2(x)) %n for j=1,2,3, ...
    For second hash function use h2(x) = 7 - (element % 7).
 */

package DataStructures.Hashing;

import java.util.*;
public class DoubleHashingMethod {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), arr[] = new int[N];
        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();
        int hash[] = new int[N];
        Arrays.fill(hash, -1);
        for(int i=0;i<N;i++) {
            int h1 = arr[i]%N;
            int h2 = 7 - (arr[i]%7);
            if(hash[h1]==-1)
                hash[h1] = arr[i];
            else {
                int j=1;
                while(hash[(h1 + j * h2)%N]!=-1)
                    j++;
                hash[(h1 + j * h2)%N] = arr[i];
            }
        }
        for(int i=0;i<N;i++)
            System.out.println("index "+i+" value = "+hash[i]);
        sc.close();
    }
}