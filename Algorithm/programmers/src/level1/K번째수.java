package level1;

import java.util.Arrays;

public class K번째수 {

    public static void main(String[] args) {
        solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    public static int[] solution(int[] array, int[][] commands) {
        // 정답 배열
        int[] answer = new int[commands.length];

        // command 배열을 돌면서
        for (int i = 0; i < commands.length; i++) {

            // 자른 배열의 크기
            int cutArrayLength = commands[i][1] - commands[i][0] + 1;
            // 자른 배열
            int[] cutArray = new int[cutArrayLength];

            int start = commands[i][0] - 1;

            // 자른 배열에 값을 추가한다.
            for (int j = 0; j < cutArrayLength; j++) {
                cutArray[j] = array[start];
                start++;
            }

            // 정렬
            Arrays.sort(cutArray);

            // 위치를 찾아내서 배열에 추가
            answer[i] = cutArray[commands[i][2]-1];
        }

        return answer;
    }
}
