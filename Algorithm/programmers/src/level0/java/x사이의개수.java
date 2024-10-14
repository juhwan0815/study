package level0.java;

import java.util.Arrays;

public class x사이의개수 {

    public static void main(String[] args) {
        int[] solution = solution("oxooxoxxox");
        System.out.println(solution);
    }

    public static int[] solution(String myString) {
        return Arrays.stream(myString.split("x", myString.length()))
                .mapToInt(String::length)
                .toArray();
    }

}
