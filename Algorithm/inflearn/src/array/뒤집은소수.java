package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 뒤집은소수 {

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

    public static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = arr[i];
            int res = 0;
            // 뒤집기
            while (temp > 0) {
                int t = temp % 10;
                res = res * 10 + t;
                temp = temp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }
        return answer;
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        // 2부터 자기 자신 전까지 약수가 발견되면 안된다.
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
