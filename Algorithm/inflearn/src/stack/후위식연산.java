package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 후위식연산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {

        List<Integer> numstack = new ArrayList<>();
        char[] arr = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(arr[i])) {
                numstack.add(Integer.parseInt(String.valueOf(arr[i])));
            } else {
                Integer num1 = numstack.remove(numstack.size() - 1);
                Integer num2 = numstack.remove(numstack.size() - 1);


                if (arr[i] == '+') {
                    numstack.add(num2 + num1);
                } else if (arr[i] == '-') {
                    numstack.add(num2 - num1);
                } else if (arr[i] == '*') {
                    numstack.add(num2 * num1);
                } else {
                    numstack.add(num2 / num1);
                }
            }

        }

        return numstack.remove(0);
    }
}
