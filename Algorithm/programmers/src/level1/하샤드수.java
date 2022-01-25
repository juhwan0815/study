package level1;

public class 하샤드수 {

    public static void main(String[] args) {
        solution(13);
    }

    public static boolean solution(int x) {
        boolean answer = false;

        // 숫자를 문자열로 변환
        String number = String.valueOf(x);

        // 문자열을 문자 배열로 변환
        char[] digits = number.toCharArray();

        int sum = 0;

        // 문자배열을 돌면서 문자를 숫자로 변환하고 더하기
        for (char digit : digits) {
            int computedNum = digit - '0';
            sum += computedNum;
        }

        // 하샤드 수 인지 확인
        answer = (x % sum) == 0 ? true : false;
        return answer;
    }
}
