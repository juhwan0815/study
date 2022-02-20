package searching;

import java.util.Arrays;
import java.util.Scanner;

public class 이분검색 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);

        int mid = arr.length / 2;

        while (true) {
            if (arr[mid] > m) {

            } else if (arr[mid] == m) {
                answer = mid;
                break;
            } else {

            }


        }


        return 0;
    }


}
