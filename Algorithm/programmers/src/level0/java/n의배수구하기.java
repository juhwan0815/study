package level0.java;

import java.util.Arrays;

public class n의배수구하기 {

    public static void main(String[] args) {
        int[] solution = solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
        System.out.println(solution);
    }

    public static int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist)
                .filter(num -> (num % n) == 0)
                .toArray();
    }
}
