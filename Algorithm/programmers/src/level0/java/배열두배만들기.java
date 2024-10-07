package level0.java;

import java.util.Arrays;

public class 배열두배만들기 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 4, 5});
        System.out.println(solution);
    }

    public static int[] solution(int[] numbers) {
        return Arrays.stream(numbers)
                .map(value -> value * 2)
                .toArray();
    }
}
