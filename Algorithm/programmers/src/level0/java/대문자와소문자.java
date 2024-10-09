package level0.java;

import java.util.stream.Collectors;

public class 대문자와소문자 {

    public static void main(String[] args) {
        String solution = solution("cccCCC");
        System.out.println(solution);
    }

    public static String solution(String my_string) {
        return my_string.chars()
                .mapToObj(value -> {
                    if (Character.
                            isUpperCase(value)) {
                        return String.valueOf((char) Character.toLowerCase(value));
                    } else {
                        return String.valueOf((char) Character.toUpperCase(value));
                    }
                })
                .collect(Collectors.joining());
    }
}
