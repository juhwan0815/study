package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 크레인인형뽑기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, map, moves));
    }

    public static int solution(int n, int m, int[][] map, int[] moves) {
        int answer = 0;

        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][moves[i] - 1] > 0) {
                    stack.add(map[j][moves[i] - 1]);

                    if (stack.size() > 2) {
                        if (stack.get(stack.size() - 2) == stack.get(stack.size() - 1)) {
                            stack.remove(stack.size() - 1);
                            stack.remove(stack.size() - 1);
                            answer += 2;
                        }
                    }

                    map[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }


        return answer;
    }

}
