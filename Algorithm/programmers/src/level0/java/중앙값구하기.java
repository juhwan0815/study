package level0.java;

import java.util.Arrays;

public class 중앙값구하기 {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 2, 7, 10, 11});
        System.out.println(solution);
    }

    public static int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}
