package level0.java;

import java.util.Arrays;

public class 콜라츠수열만들기 {

    public static void main(String[] args) {
        int[] solution = solution(10);
        System.out.println(solution);
    }

    public static int[] solution(int n) {
        int[] answer = new int[0];

        int offset = 0;

        while (true) {
            answer = Arrays.copyOf(answer, answer.length + 1);
            answer[offset] = n;
            offset++;

            if (n == 1) {
                break;
            }

            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
        }

        return answer;
    }

}
