package level0.java;

import java.util.stream.Collectors;

public class 문자반복출력하기 {

    public static void main(String[] args) {
        String solution = solution("hello", 3);
        System.out.println(solution);
    }

    public static String solution(String my_string, int n) {
        return my_string.chars()
                .mapToObj(value -> String.valueOf((char) value).repeat(n))
                .collect(Collectors.joining());

    }
}
