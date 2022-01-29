package level1;

import java.util.ArrayList;
import java.util.List;

public class 크레인인형뽑기게임 {

    public static void main(String[] args) {
        solution(new int[][]{
                        {0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 3},
                        {0, 2, 5, 0, 1},
                        {4, 2, 4, 4, 2},
                        {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4});
    }

    public static int solution(int[][] board, int[] moves) {
        // 스택을 만든다.
        List<Integer> bucket = new ArrayList<>();
        int currentIndex = -1;
        // 터진 점수
        int count = 0;

        for (int i = 0; i < moves.length; i++) {
            // 움직임을 돌면서
            int move = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                // 맨 위의 인형을 뽑다.
                if (board[j][move] != 0) {
                    bucket.add(board[j][move]);
                    currentIndex++;

                    // 2개 이상 쌓엿을 때
                    if (currentIndex > 0) {
                        // 맨 끝 인형과 그 앞 인형이 같으면 터뜨린다.
                        if (bucket.get(currentIndex) == bucket.get(currentIndex - 1)) {
                            bucket.remove(currentIndex);
                            bucket.remove(currentIndex - 1);
                            currentIndex -= 2;
                            count += 2;
                        }
                    }

                    // 뽑은 부분은 빈곳으로 치환
                    board[j][move] = 0;
                    break;
                }
            }
        }


        return count;
    }
}
