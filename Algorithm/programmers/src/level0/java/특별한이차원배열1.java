package level0.java;

public class 특별한이차원배열1 {

    public static void main(String[] args) {
        int[][] solution = solution(3);
        System.out.println(solution);
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }

        return answer;
    }
}
