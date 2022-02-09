package array;

import java.util.Scanner;

public class 봉우리 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] numArray = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                numArray[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(numArray));
    }

    public static int solution(int[][] numArray) {
        int[][] map = new int[numArray.length + 2][numArray.length + 2];
        int result = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0 || j == 0 || i == (map.length - 1) || j == (map.length - 1)) {
                    map[i][j] = 0;
                    continue;
                }

                map[i][j] = numArray[i - 1][j - 1];
            }
        }

        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map.length - 1; j++) {
                if(map[i][j] > map[i-1][j] && map[i][j] > map[i+1][j] && map[i][j] > map[i][j+1] && map[i][j] > map[i][j-1]){
                    result++;
                }
            }
        }

        return result;
    }
}
