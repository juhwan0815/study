package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급회장 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();

        System.out.println(solution(n, str));
    }

    public static String solution(int n, String str) {

        Map<String, Integer> repository = new HashMap<>();

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (repository.containsKey(String.valueOf(c))) {
                int num = repository.get(String.valueOf(c));
                repository.put(String.valueOf(c), ++num);
            } else {
                repository.put(String.valueOf(c), 1);
            }
        }

        String answer = "";
        int max = 0;
        for (String s : repository.keySet()) {
            if (max < repository.get(s)) {
                max = repository.get(s);
                answer = s;
            }
        }

        return answer;
    }

}
