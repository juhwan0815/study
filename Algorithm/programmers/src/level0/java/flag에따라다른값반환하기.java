package level0.java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class flag에따라다른값반환하기 {

    public static void main(String[] args) {
        int solution = solution(-4, 7, true);
        System.out.println(solution);
    }

    public static   int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }
}
