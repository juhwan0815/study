package array;

import java.util.*;

public class 임시반장정하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n + 1][6]; // 1~5 학년
        for (int i = 1; i <= n; i++) { // 학생 수
            for (int j = 1; j <= 5; j++) { // 학년
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;


        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) { // i 학생과 같은 반을 한 J번 학생이 몇명있는지 체크
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                answer = i;
            }
        }

        return answer;
    }

}
