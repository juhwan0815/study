package level0;

import java.util.Arrays;

public class 배열자르기 {

    public static void main(String[] args) {
        solution(new int[]{1,2,3,4,5}, 1, 3);
    }

    public static int[] solution(int[] numbers, int num1, int num2) {

        int[] answer = Arrays.copyOfRange(numbers, num1, num2 + 1);

        return answer;
    }

}
