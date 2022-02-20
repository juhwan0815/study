package sorting;

import java.util.Arrays;
import java.util.Scanner;

public class 삽입정렬 {

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
        Arrays.sort(arr);
        return arr;
    }
}
