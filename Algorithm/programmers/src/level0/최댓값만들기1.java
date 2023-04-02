package level0;

import java.util.Arrays;

public class 최댓값만들기1 {

    public static void main(String[] args) {
        solution(new int[]{0, 31, 24, 10, 1, 9});
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);
        answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        return answer;
    }

}
