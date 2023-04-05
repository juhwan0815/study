package level0;

import java.util.Arrays;

public class N차원으로만들기 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 2);
    }

    public static int[][] solution(int[] num_list, int n) {
        int height = num_list.length / n;

        int[][] answer = new int[height][n];

        for(int i = 0; i < height; i++) {
            int[] copyArray = Arrays.copyOfRange(num_list, i * n, (i+1) * n);
            answer[i] = copyArray;
        }

        return answer;
    }

}
