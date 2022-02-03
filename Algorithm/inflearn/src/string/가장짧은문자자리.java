package string;

import java.util.Scanner;

public class 가장짧은문자자리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char c = scanner.next().charAt(0);
        for (int i : solution(str, c)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];

        int p = 1000;
        // --> 왼쪽을 기준으로 거리 체크
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                p = 0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }

        // <-- 오른쪽을 기준으로 거리 체크
        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == c) {
                p = 0;
            } else {
                p++;
                // 원래 들어있던 거리와 비교를 하고 넣어준다.
                answer[i] = Math.min(p, answer[i]);
            }
        }

        return answer;
    }
}
