package level0;

import java.util.Arrays;

public class A로B만들기 {

    public static void main(String[] args) {
        solution("olleh", "hello");
    }

    public static int solution(String before, String after) {
        int answer = 0;

        char[] beforeChars = before.toCharArray();
        char[] afterChars = after.toCharArray();

        Arrays.sort(beforeChars);
        Arrays.sort(afterChars);

        before = String.valueOf(beforeChars);
        after = String.valueOf(afterChars);

        answer = before.equals(after) ? 1 : 0;
        return answer;
    }

}
