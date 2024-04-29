package LogicalThinking;

import java.util.*;
public class ReverseSpiralMatrix{
    public static void main(String h[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        int r[]=spiral(a,n,m);
        for(int i=0;i<n*m;i++)
        {
            System.out.print(r[i]+" ");
        }
        sc.close();
    }
    public static int[] spiral(int[][] a,int n,int m)
    {
        int r[]=new int[n*m];
        int tr=0,br=n-1,lc=0,rc=m-1,in=0;
        while(tr<=br && lc<=rc)
        {
            for(int i=tr;i<=br;i++)
            {
                r[in++]=a[i][lc];
            }
            lc++;
            for(int i=lc;i<=rc;i++)
            {
                r[in++]=a[br][i];
            }
            br--;
            if(lc<=rc)
            {
                for(int i=br;i>=tr;i--)
                {
                    r[in++]=a[i][rc];
                }
                rc--;
            }
            if(tr<=br)
            {
                for(int i=rc;i>=lc;i--)
                {
                    r[in++]=a[tr][i];
                }
                tr++;
            }
        }
        return r;
    }
}