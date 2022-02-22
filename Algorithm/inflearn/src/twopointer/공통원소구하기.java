package twopointer;

import java.util.*;

public class 공통원소구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : solution(n, m, a, b)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int m, int[] arr1, int[] arr2) {

        return null;
    }
}
