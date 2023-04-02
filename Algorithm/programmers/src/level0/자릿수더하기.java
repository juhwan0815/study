package level0;

public class 자릿수더하기 {

    public static void main(String[] args) {
        solution(1234);
    }

    public static int solution(int n) {
        int answer = 0;

        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            answer += Integer.parseInt(String.valueOf(c));
        }

        return answer;
    }
}
