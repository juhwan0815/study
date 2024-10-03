package level0.java;

import java.util.stream.IntStream;

public class 짝수의합 {

    public static void main(String[] args) {
        int solution = solution(10);
        System.out.println(solution);
    }

    public static int solution(int n) {
        return IntStream.rangeClosed(0, n)
                .filter(value -> value % 2 == 0)
                .sum();
    }
}
