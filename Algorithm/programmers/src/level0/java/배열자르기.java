package level0.java;

import java.util.Arrays;

public class 배열자르기 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 4, 5}, 1, 3);
        System.out.println(solution);
    }

    public static int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}
