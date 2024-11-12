package level0.java;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 부분문자열이어붙여문자열만들기 {

    public static void main(String[] args) {
        String solution = solution(new String[]{
                "progressive", "hamburger", "hammer", "ahocorasick"
        }, new int[][]{{0, 4}, {1, 2}, {3, 5}, {7, 7}});
        System.out.println(solution);
    }

    public static String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length)
                .mapToObj(value -> my_strings[value].substring(parts[value][0], parts[value][1] + 1))
                .collect(Collectors.joining());
    }
}
