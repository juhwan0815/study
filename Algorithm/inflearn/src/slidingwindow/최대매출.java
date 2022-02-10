package slidingwindow;

import java.util.Scanner;

public class 최대매출 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(arr, n, k));
    }

    public static int solution(int[] arr, int n, int k) {
        int answer = 0;

        for (int i = 0; i < n - k; i++) {
            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }

            if(answer < sum){
                answer = sum;
            }
        }

        return answer;
    }

}
