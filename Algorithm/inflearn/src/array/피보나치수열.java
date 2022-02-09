package array;

import java.util.*;

public class 피보나치수열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x : solution(n)) {
            System.out.print(x + " ");
        }
    }

    /**
     * 배열 사용
     */
    public static int[] solution(int n) {
        int[] answer = new int[n];
        answer[0] = 1;
        answer[1] = 1;

        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    /**
     * 배열 사용 X
     */
    public static void solution1(int n) {
        int a = 1;
        int b = 1;
        int c;

        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
