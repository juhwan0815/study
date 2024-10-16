package level0.java;

import java.util.stream.IntStream;

public class 카운트다운 {

    public static void main(String[] args) {
        int[] solution = solution(10, 3);
        System.out.println(solution);
    }

    public static int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(0, start_num - end_num)
                .map(i -> start_num - i)
                .toArray();
    }
}
