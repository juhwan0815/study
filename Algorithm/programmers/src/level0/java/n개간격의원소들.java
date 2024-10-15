package level0.java;

import java.util.stream.IntStream;

public class n개간격의원소들 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{4, 2, 6, 1, 7, 6}, 2);
        System.out.println(solution);
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.range(0, num_list.length)
                .filter(value -> value % n == 0)
                .map(value -> num_list[value])
                .toArray();
    }
}
