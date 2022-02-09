package array;

import java.util.Scanner;

public class 격자판최대합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;

        int sum1;// 행의 합
        int sum2; // 열의 합

        for (int i = 0; i < n; i++) {
            sum1 = 0;
            sum2 = 0;
            // 행과 열 계산
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = 0;
        sum2 = 0;

        // 대각선 계산
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][5 - i - 1];
        }

        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
