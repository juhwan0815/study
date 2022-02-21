package level2;

import java.util.Arrays;

public class 최솟값만들기 {

    public static void main(String[] args) {
        solution(new int[]{1, 4, 2}, new int[]{5, 4, 4});
    }

    public static int solution(int[] arrA, int[] arrB) {
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int answer = 0;

        for (int i = 0; i < arrA.length; i++) {
            answer += arrA[i] * arrB[arrB.length - 1 - i];
        }

        return answer;
    }
}
