package level0;

import java.util.Arrays;

public class 최댓값만들기2 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, -3, 4, -5});
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);

        answer = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        if(answer < numbers[0] * numbers[1]) {
            answer = numbers[0] * numbers[1];
        }
        return answer;
    }

}
