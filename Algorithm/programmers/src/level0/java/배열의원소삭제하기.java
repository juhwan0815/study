package level0.java;

import java.util.Arrays;

public class 배열의원소삭제하기 {

    public static void main(String[] args) {
        int solution[] = solution(
                new int[]{293, 1000, 395, 678, 94},
                new int[]{94, 777, 104, 1000, 1, 12}
        );
        System.out.println(solution);
    }

    public static int[] solution(int[] arr, int[] delete_list) {
        return Arrays.stream(arr)
                .filter(value -> Arrays.stream(delete_list)
                        .allMatch(deleteValue -> value != deleteValue))
                .toArray();
    }
}
