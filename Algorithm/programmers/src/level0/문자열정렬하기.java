package level0;

import java.util.Arrays;

public class 문자열정렬하기 {

    public static void main(String[] args) {
        solution("heLLo");
    }

    public static String solution(String my_string) {
        String answer = "";

        char[] chars = my_string.toLowerCase().toCharArray();

        Arrays.sort(chars);

        answer = String.valueOf(chars);
        return answer;
    }

}
