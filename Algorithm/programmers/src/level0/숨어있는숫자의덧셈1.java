package level0;

public class 숨어있는숫자의덧셈1 {

    public static void main(String[] args) {
        solution("1a2b3c4d123");
    }

    public static int solution(String my_string) {
        int answer = 0;

        char[] chars = my_string.toCharArray();

        for (char c : chars) {
            if(Character.isDigit(c)) {
                answer += Integer.parseInt(String.valueOf(c));
            }
        }

        return answer;
    }

}
