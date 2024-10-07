package level0.java;

import java.util.Arrays;

public class 배열원소의길이 {

    public static void main(String[] args) {
        int[] solution = solution(new String[]{"We", "are", "the", "world!"});
        System.out.println(solution);
    }

    public static int[] solution(String[] strlist) {
        return Arrays.stream(strlist)
                .mapToInt(String::length)
                .toArray();
    }
}
