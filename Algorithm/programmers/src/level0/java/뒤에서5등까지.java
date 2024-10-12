package level0.java;

import java.util.Arrays;

public class 뒤에서5등까지 {

    public static void main(String[] args) {
        int solution[] = solution(new int[] {12, 4, 15, 46, 38, 1, 14});
        System.out.println(solution);
    }

    public static int[] solution(int[] num_list) {
        return Arrays.stream(num_list)
                .sorted()
                .limit(5)
                .toArray();
    }
}
