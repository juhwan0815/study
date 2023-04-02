package level0;

import java.util.Arrays;

public class 문자반복출력하기 {

    public static void main(String[] args) {
        solution("hello", 3);
    }

    public static String solution(String my_string, int n) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        char[] charArray = my_string.toCharArray();

        for(char c : charArray) {
            for(int i = 0; i < n; i++) {
                sb.append(c);
            }
        }

        answer = sb.toString();
        return answer;
    }

}
