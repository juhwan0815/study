package level0.java;

import java.util.stream.IntStream;

public class 카운트업 {

    public static void main(String[] args) {
        int[] solution = solution(3, 10);
        System.out.println(solution);
    }

    public static int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num, end_num)
                .toArray();
    }
}
