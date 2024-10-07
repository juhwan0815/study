package level0.java;

import java.util.Arrays;

public class 배열의평균값 {

    public static void main(String[] args) {
        double solution = solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(solution);
    }

    public static double solution(int[] numbers) {
        return Arrays.stream(numbers)
                .average()
                .orElse(0);
    }
}
