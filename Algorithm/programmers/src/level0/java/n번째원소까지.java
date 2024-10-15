package level0.java;

import java.util.Arrays;

public class n번째원소까지 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 1, 6}, 1);
        System.out.println(solution);
    }

    public static int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, 0, n);
    }
}
