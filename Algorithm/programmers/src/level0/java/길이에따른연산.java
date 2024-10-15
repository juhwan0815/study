package level0.java;

import java.util.Arrays;

public class 길이에따른연산 {

    public static void main(String[] args) {
        int solution = solution(new int[]{2, 3, 4, 5});
        System.out.println(solution);
    }

    public static int solution(int[] num_list) {
        return num_list.length >= 11
                ? Arrays.stream(num_list).sum()
                : Arrays.stream(num_list)
                .reduce((left, right) -> left * right)
                .getAsInt();
    }

}
