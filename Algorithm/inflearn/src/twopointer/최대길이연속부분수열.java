package twopointer;

import java.util.Scanner;

public class 최대길이연속부분수열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int count = 0; // 0을 1로 바꾼 횟수
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                count++;
            }

            // 조정
            while (count > k) {
                if (arr[lt] == 0) {
                    count--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);

        }

        return answer;
    }
}
