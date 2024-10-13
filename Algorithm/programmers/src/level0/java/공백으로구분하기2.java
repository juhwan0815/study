package level0.java;

import java.util.Arrays;

public class 공백으로구분하기2 {

    public static void main(String[] args) {
        String[] solution = solution(" i    love  you");
        System.out.println(solution);
    }

    public static String[] solution(String my_string) {
        return Arrays.stream(my_string.trim().split(" "))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
    }

}
