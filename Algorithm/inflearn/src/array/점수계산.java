package array;

import java.util.Scanner;

public class 점수계산 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[] arr) {
        int answer = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                count++;
                answer += count;
            } else {
                count = 0;
            }
        }

        return answer;
    }
}
