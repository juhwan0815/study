package level0.java;

import java.util.stream.Collectors;

public class 문자열바꿔서찾기 {

    public static void main(String[] args) {
        int solution = solution("ABBAA", "AABB");
        System.out.println(solution);
    }

    public static int solution(String myString, String pat) {
        return myString.chars()
                .mapToObj(value -> {
                    if ('A' == (char) value) {
                        return "B";
                    } else {
                        return "A";
                    }
                })
                .collect(Collectors.joining())
                .contains(pat) ? 1 : 0;
    }

}
