package queue;

import java.util.*;

public class 괄호문자제거 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        List<Character> queue = new ArrayList<>();
        char[] arr = str.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                queue.add('(');
            } else if (arr[i] == ')') {
                if (queue.size() > 0) {
                    queue.remove(0);
                }
            }

            if (queue.size() == 0) {
                if (Character.isAlphabetic(arr[i])) {
                    answer += arr[i];
                }
            }
        }

        return answer;
    }

}
