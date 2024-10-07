package level0.java;

import java.util.Arrays;

public class 중복된숫자개수 {

    public static void main(String[] args) {
        int solution = solution(new int[]{0,2,3,4}, 1);
        System.out.println(solution);
    }

    public static int solution(int[] array, int n) {
        return (int) Arrays.stream(array)
                .filter(value -> value == n)
                .count();
    }
}
