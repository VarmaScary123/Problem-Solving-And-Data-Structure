package LogicalThinking.Others;

/*
    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.

    Example 1:

    Input: n = 3
    Output: ["1","2","Fizz"]
    Example 2:

    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]
    Example 3:

    Input: n = 15
    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

    Constraints:
    1 <= n <= 104
 */

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for(int i=1;i<=n;i++) {
            boolean divisibleby3 = i % 3 == 0;
            boolean divisibleby5 = i % 5 == 0;

            if(divisibleby3 && divisibleby5)
                result.add("FizzBuzz");
            else if(divisibleby3) 
                result.add("Fizz");
            else if(divisibleby5)
                result.add("Buzz");
            else
                result.add(String.valueOf(i));
        }

        return result;
    }
}
