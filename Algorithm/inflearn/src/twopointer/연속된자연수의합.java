package twopointer;

import java.util.Scanner;

public class 연속된자연수의합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution2(n));
    }

    /**
     * 수학
     */
    public static int solution2(int n) {
        int answer = 0;
        int count = 1; // 연속된 자연수의 개수
        n--; // 1을 먼저 뺀다.

        while (n > 0) {
            count++;
            n = n - count;
            if(n % count == 0){ // 1,2 빼고 n을 2로 나누면 6
                answer++;
            }
        }

        return answer;
    }

    /**
     * two pointer
     */
    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;

        // 배열을 채운다.
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        // rt를 증가시키면서
        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }

            // 합이 n보다 크면 lt 를 증가시키면서 이동
            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }


}
