package level0.java;

import java.util.stream.IntStream;

public class 배열만들기1 {

    public static void main(String[] args) {
        int[] solution = solution(15, 5);
        System.out.println(solution);
    }

    public static int[] solution(int n, int k) {
        return IntStream.rangeClosed(1, n)
                .filter(value -> value % k == 0)
                .toArray();
    }
}
