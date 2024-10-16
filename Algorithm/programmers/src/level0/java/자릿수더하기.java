package level0.java;

import java.util.Arrays;

public class 자릿수더하기 {

    public static void main(String[] args) {
        int solution = solution(930211);
        System.out.println(solution);
    }

    public static int solution(int n) {
        return Arrays.stream(String.valueOf(n).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
