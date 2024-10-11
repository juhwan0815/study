package level0.java;

import java.util.Arrays;

public class 원소들의곱과합 {

    public static void main(String[] args) {
        int solution = solution(new int[]{3, 4, 5, 2, 1});
        System.out.println(solution);
    }

    public static int solution(int[] num_list) {
        return Arrays.stream(num_list)
                .reduce((left, right) -> left * right)
                .getAsInt() < Math.pow(Arrays.stream(num_list).sum(), 2) ? 1 : 0;
    }
}
