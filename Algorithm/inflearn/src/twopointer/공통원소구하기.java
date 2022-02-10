package twopointer;

import java.util.*;

public class 공통원소구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }

        for (int x : solution(n, m, arr1, arr2)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int m, int[] arr1, int[] arr2) {

        return null;
    }
}
