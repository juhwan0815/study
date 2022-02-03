package level2;

public class 행렬의곱셈 {

    public static void main(String[] args) {
//        solution(new int[][]{
//                {1, 4,},
//                {3, 2},
//                {4, 1}}, new int[][]{
//                {3, 3},
//                {3, 3}});

//        solution(new int[][]{{2, 3, 2},
//                {4, 2, 4}
//                , {3, 1, 4}}, new int[][]{
//                {5, 4, 3},
//                {2, 4, 1},
//                {3, 1, 1}});
        solution(new int[][]{{1, 2, 3},
                {4, 5, 6}}, new int[][]{{1, 4},
                {2, 5},
                {3, 6}});
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        //  N * M 행렬과 M * N 행렬이 곱해지면 N * N 행렬이 나온다.
        int[][] answer = new int[arr1.length][arr2[0].length];

        // N 번 반복
        for (int i = 0; i < arr1.length; i++) {
            // N 번 반복
            for (int j = 0; j < arr2[0].length; j++) {
                int sum = 0;
                // N 행의 요소와 N 렬의 요소를 곱하고 더한다.
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }

                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
