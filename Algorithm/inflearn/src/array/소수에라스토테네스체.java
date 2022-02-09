package array;

import java.util.Scanner;

public class 소수에라스토테네스체 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int[] numArray = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (numArray[i] == 0) {
                answer++;
                for (int j = i * 2; j <= n; j += i) {
                    numArray[j] = 1;
                }
            } else {
                continue;
            }
        }

        return answer;
    }
}
