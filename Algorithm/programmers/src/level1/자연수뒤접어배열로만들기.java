package level1;

public class 자연수뒤접어배열로만들기 {

    public static void main(String[] args) {
        solution(12345);
    }

    public static int[] solution(long n) {
        // 숫자를 문자열로 변경
        String stringNum = String.valueOf(n);

        // 문자열로 배열 생성
        int[] answer = new int[stringNum.length()];

        // StringBuilder 를 사용해서 reverse
        StringBuilder stringBuilder = new StringBuilder(stringNum);
        String reverseNum = stringBuilder.reverse().toString();

        // 문자열을 char 배열로 변경
        char[] chars = reverseNum.toCharArray();
        for (int i = 0; i < stringNum.length(); i++) {
            // char -> String 로 변경 -> 정수로 변경
            answer[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return answer;
    }
}
