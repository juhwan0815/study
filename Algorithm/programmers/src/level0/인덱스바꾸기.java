package level0;

public class 인덱스바꾸기 {

    public static void main(String[] args) {
        solution("hello", 1, 2);
    }

    public static String solution(String my_string, int num1, int num2) {
        String answer = "";

        char[] chars = my_string.toCharArray();

        char c1 = chars[num1];
        char c2 = chars[num2];

        chars[num1] = c2;
        chars[num2] = c1;

        answer = String.valueOf(chars);

        return answer;
    }
}
