package level1;

public class 자릿수더하기 {

    public static void main(String[] args) {
        solution(987);
    }

    public static int solution(int n) {
        int sum = 0;

        // 정수를 문자열로 변환후 문자열을 문자 배열로 변환
        String strNum = String.valueOf(n);
        char[] charArray = strNum.toCharArray();

        // 문자 배열을 돌면서 문자를 숫자로 변환한뒤 더한다.
        for (char c : charArray) {
            sum += Integer.parseInt(String.valueOf(c));
        }

        return sum;
    }
}
