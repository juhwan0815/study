package level2;

public class 땅따먹기 {

    public static void main(String[] args) {
        solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}});
        solution(new int[][]{
                {4, 3, 2, 1},
                {2, 2, 2, 1},
                {6, 6, 6, 4},
                {8, 7, 6, 5}});
    }

    public static int solution(int[][] land) {
        int answer = 0;

        int row = -1;
        for (int i = 0; i < land.length; i++) {
            int max = 0;
            int maxRow = -1;
            for (int j = 0; j < land[i].length; j++) {
                if (j == row) {
                    continue;
                }

                if (max <= land[i][j]) {
                    max = land[i][j];
                    maxRow = j;
                }
            }

            answer += max;
            row = maxRow;
        }

        return answer;
    }
}
