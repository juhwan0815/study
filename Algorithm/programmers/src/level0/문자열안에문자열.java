package level0;

public class 문자열안에문자열 {

    public static void main(String[] args) {
        solution("ab6CDE443fgh22iJKlmn1o", "6CD");
    }

    public static int solution(String str1, String str2) {
        int answer = str1.contains(str2) ? 1 : 2;
        return answer;
    }

}
