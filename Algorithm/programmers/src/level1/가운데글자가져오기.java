package level1;

public class 가운데글자가져오기 {

    public static void main(String[] args) {
        solution("a");
    }

    public static String solution(String s) {
        String answer = "";
        // 문자열의 길이를 2로 나눈다.
        int index = s.length() / 2;

        if ((s.length() % 2) == 0) {
            // 문자열 길이가 짝수면 가운데 2개
            answer = s.substring(index - 1, index + 1);
        } else {
            // 문자열의 길이가 홀수면 가운데 1개
            answer = s.substring(index, index + 1);
        }

        return answer;
    }
}
