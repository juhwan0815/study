package level0;

import java.util.Arrays;

public class 문자열정렬하기1 {

    public static void main(String[] args) {
        solution("hi12392");
    }

    public static int[] solution(String my_string) {
        int[] answer = {};

        StringBuffer sb = new StringBuffer();

        char[] chars = my_string.toCharArray();

        for(char c : chars) {
            if(Character.isDigit(c)) {
                sb.append(c);
            }
        }

        String numberString = sb.toString();
        char[] numChars = numberString.toCharArray();
        answer = new int[numChars.length];

        for(int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(String.valueOf(numChars[i]));
        }

        Arrays.sort(answer);

        return answer;
    }

}
