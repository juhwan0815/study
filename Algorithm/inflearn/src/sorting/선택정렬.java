package sorting;

import java.util.Scanner;

public class 선택정렬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : solution(n, arr)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int[] arr) {

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }
}
