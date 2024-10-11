package level0.java;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 부분문자열 {

    public static void main(String[] args) {
        int solution = solution("abc", "aabcc");
        System.out.println(solution);
    }

    public static int solution(String str1, String str2) {
        return str2.contains(str1) ? 1 : 0;
    }
}
