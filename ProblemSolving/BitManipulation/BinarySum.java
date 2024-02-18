package BitManipulation;

import java.util.Scanner;

public class BinarySum {
    public static int binarySum(String num1, String num2) {
        int n1 = Integer.parseInt(num1, 2);
        int n2 = Integer.parseInt(num2, 2);

        while(n2 != 0) {
            int carry = n1 & n2;
            n1 = n1 ^ n2;
            n2 = carry << 1;
        }
        return n1;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String num1= sc.next(), num2 = sc.next();
        System.out.println(Integer.toBinaryString(binarySum(num1, num2)));
        sc.close();
    }
}
