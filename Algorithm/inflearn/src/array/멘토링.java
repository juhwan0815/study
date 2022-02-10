package array;

import java.util.Scanner;

public class 멘토링 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, m, arr));
    }

    /**
     * m : 시험 개수, n : 등수, 사람 수
     */
    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        // 멘토 멘티가 될 가지수는 n제곱 가지 (중복포함)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int count = 0;
                // 2차원 배열에서 i 사람이 j 사람보다 m번의 시험에서 높은 개수를 찾는다.
                for (int k = 0; k < m; k++) {
                    // 시험에서 등수가 높은지 확인
                    int pi = 0;
                    int pj = 0;
                    for (int s = 0; s < n; s++) {
                        if (arr[k][s] == i) {
                            pi = s; // i 사람 등수
                        }
                        if (arr[k][s] == j) {
                            pj = s; // J 사람 등수
                        }
                    }

                    if (pi < pj) {
                        count++;
                    }
                }
                // 모든 시험을 돌고 난뒤 m번 만큼 높다면 멘토가 된다.
                if (count == m) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
