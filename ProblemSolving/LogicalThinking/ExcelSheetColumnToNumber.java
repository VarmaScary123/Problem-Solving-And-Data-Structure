package LogicalThinking;

import java.util.*;

public class ExcelSheetColumnToNumber {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next().toUpperCase();
        int columnNumber = 0;
        for(int i=0;i<s.length();i++) {
            columnNumber = columnNumber * 26 + (s.charAt(i) - 'A' + 1);
        }
        System.out.println(columnNumber);
        sc.close();
    }
}
