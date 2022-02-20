package searching;

import java.util.Arrays;
import java.util.Scanner;

public class 장난꾸러기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for(int i : solution(n, arr)){
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int n, int[] arr) {
        int[] result = new int[2];
        int count = 0;

        int[] compareArr = new int[arr.length];

        for (int i = 0; i < n; i++) {
            compareArr[i] = arr[i];
        }

        Arrays.sort(compareArr);

        for (int i = 0; i < n; i++) {
            if (arr[i] != compareArr[i]) {
                result[count] = i + 1;
                count++;
            }
        }

        return result;
    }
}
