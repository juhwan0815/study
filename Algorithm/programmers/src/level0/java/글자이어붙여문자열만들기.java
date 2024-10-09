package level0.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 글자이어붙여문자열만들기 {

    public static void main(String[] args) {
        String solution = solution(
                "cvsgiorszzzmrpaqpe",
                new int[]{16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7}
        );
        System.out.println(solution);
    }

    public static String solution(String my_string, int[] index_list) {
        return Arrays.stream(index_list)
                .mapToObj(num -> String.valueOf(my_string.charAt(num)))
                .collect(Collectors.joining());
    }
}
