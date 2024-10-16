package level0.java;

import java.util.stream.IntStream;

public class 약수구하기 {

    public static void main(String[] args) {
        int[] solution = solution(24);
        System.out.println(solution);
    }

    public static int[] solution(int n) {
        return IntStream.rangeClosed(1, n)
                .filter(value -> n % value == 0)
                .toArray();
    }
}
