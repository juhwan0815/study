package level0.java;

import java.util.Arrays;

public class 배열의원소만큼추가하기 {

    public static void main(String[] args) {
        int solution[] = solution(new int[]{5, 1, 4});
        System.out.println(solution);
    }

    public static int[] solution(int[] arr) {
        int sum = Arrays.stream(arr)
                .sum();

        int[] answer = new int[sum];
        int offset = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i]; j++) {
                answer[offset] = arr[i];
                offset++;
            }
        }

        return answer;
    }
}
