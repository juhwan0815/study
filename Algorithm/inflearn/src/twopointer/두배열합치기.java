package twopointer;

import java.util.Scanner;

public class 두배열합치기 {

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
        int[] answer = new int[n + m];

        int p1 = 0;
        int p2 = 0;

        for (int i = 0; i < answer.length; i++) {
            if (p1 == arr1.length) {
                answer[i] = arr2[p2];
                p2++;
                continue;
            } else if (p2 == arr2.length) {
                answer[i] = arr1[p1];
                p1++;
                continue;
            }

            if (arr1[p1] < arr2[p2]) {
                answer[i] = arr1[p1];
                p1++;
            } else {
                answer[i] = arr2[p2];
                p2++;
            }
        }


        return answer;
    }


}
