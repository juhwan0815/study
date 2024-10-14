
package level0.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 순서바꾸기 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{5, 2, 1, 7, 5}, 3);
        System.out.println(solution);
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.concat(
                Arrays.stream(num_list).skip(n),
                Arrays.stream(num_list).limit(n))
                .toArray();
    }

}
