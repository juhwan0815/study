package slidingwindow;

import java.util.Scanner;

public class 최대길이연속부분수열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, c, arr));
    }

    public static int solution(int n, int c, int[] arr) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int size = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    if (count == c) {
                        max = Math.max(max, size);
                        break;
                    }
                    count++;
                }
                size++;
            }
        }


        return max;
    }
}
