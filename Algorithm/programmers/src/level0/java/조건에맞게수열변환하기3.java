package level0.java;

import java.util.Arrays;

public class 조건에맞게수열변환하기3 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 100, 99, 98}, 3);
        System.out.println(solution);
    }

    public static int[] solution(int[] arr, int k) {
        return Arrays.stream(arr)
                .map(num -> k % 2 == 0 ? num + k : num * k)
                .toArray();
    }
}
