package level0.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 꼬리문자열 {

    public static void main(String[] args) {
        String solution = solution(new String[]{"abc", "bbc", "cbc"}, "c");
        System.out.println(solution);
    }

    public static String solution(String[] str_list, String ex) {
        return Arrays.stream(str_list)
                .filter(str -> !str.contains(ex))
                .collect(Collectors.joining());
    }
}
