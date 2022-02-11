package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 올바른괄호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "YES";

        List<Character> queue = new ArrayList<>();

        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (i == 1) {
                if (arr[i] == ')') {
                    answer = "NO";
                    break;
                }
            }

            if (arr[i] == '(') {
                queue.add('(');
            } else {
                if (queue.size() > 0) {
                    queue.remove(0);
                } else {
                    answer = "NO";
                    break;
                }
            }
        }


        return answer;
    }
}
