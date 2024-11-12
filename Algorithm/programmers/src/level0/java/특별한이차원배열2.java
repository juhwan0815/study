package level0.java;

public class 특별한이차원배열2 {

    public static void main(String[] args) {
        int solution = solution(new int[][]{
                {5, 192, 33}, {192, 72, 95}, {33, 95, 999}
        });
        System.out.println(solution);
    }

    public static int solution(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) {
                    return 0;
                }
            }
        }

        return 1;
    }
}
