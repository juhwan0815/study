package level0.java;

import java.util.stream.IntStream;

public class 홀짝에따라다른값반환하기 {

    public static void main(String[] args) {
        int solution = solution(10);
        System.out.println(solution);
    }

    public static int solution(int n) {
        return n % 2 != 0
                ? IntStream.rangeClosed(1, n)
                .filter(value -> value % 2 != 0)
                .sum()
                : IntStream.rangeClosed(1, n)
                .filter(value -> value % 2 ==0)
                .map(value -> (int) Math.pow(value, 2))
                .sum();

    }
}
