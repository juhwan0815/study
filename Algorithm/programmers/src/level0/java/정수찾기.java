package level0.java;

import java.util.Arrays;

public class 정수찾기 {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println(solution);
    }

    public static int solution(int[] num_list, int n) {
        return Arrays.stream(num_list)
                .anyMatch(num -> num == n) ? 1 : 0;
    }
}
