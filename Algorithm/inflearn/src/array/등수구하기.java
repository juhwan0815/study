package array;

import java.util.*;

public class 등수구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = 0; j < n; i++) {
                if (arr[j] > arr[i]) {
                    count++;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}
