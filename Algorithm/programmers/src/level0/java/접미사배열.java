package level0.java;

import java.util.stream.IntStream;

public class 접미사배열 {

    public static void main(String[] args) {
        String[] solution = solution("banana");
        System.out.println(solution);
    }

    public static String[] solution(String my_string) {
        return IntStream.range(0, my_string.length())
                .mapToObj(my_string::substring)
                .sorted()
                .toArray(String[]::new);
    }
}
