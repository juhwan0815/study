package array;

import java.util.Scanner;

public class 봉우리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, arr));
    }

    public static int solution(int n, int[][] arr) {
        // 상하좌우
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean check = true;
                // 4방향
                for (int k = 0; k < 4; k++) {
                    // 행 좌표
                    int nx = i + dx[k];
                    // 열 좌표
                    int ny = j + dy[k];
                    // 봉우리인지 확인
                    // 먼저 가장자리를 걸러낸다.
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        check = false;
                        break;
                    }
                }

                if(check){
                    answer++;
                }
            }
        }
        return answer;
    }
}
