package level0.java;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class 가까운1찾기 {

    public static void main(String[] args) {
        int solution = solution(new int[]{1, 1, 1, 1, 0}, 3);
        System.out.println(solution);
    }

    public static int solution(int[] arr, int idx) {
        return IntStream.range(idx, arr.length)
                .filter(value -> arr[value] == 1)
                .findFirst()
                .orElse(-1);
    }
}
