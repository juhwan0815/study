package sorting;

import java.util.Scanner;

public class 버븗정렬 {

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
            for (int j = i; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


        return arr;
    }
}
