package level0.java;

import java.util.Arrays;

public class 조건에맞게수열변환하기1 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 2, 3, 100, 99, 98});
        System.out.println(solution);
    }

    public static int[] solution(int[] arr) {
        return Arrays.stream(arr)
                .map(num -> {
                    if (num >= 50 && num % 2 == 0) {
                        return num / 2;
                    } else if (num < 50 && num % 2 == 1) {
                        return num * 2;
                    } else {
                        return num;
                    }
                })
                .toArray();
    }
}
