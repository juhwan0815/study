package level1;

public class X진법뒤집기 {

    public static void main(String[] args) {
        solution(45);
    }

    public static int solution(int n) {
        // 10진수를 n 진수로 변환하기
        String computeSeven = "";
        while (n > 0) { // 반복
            computeSeven = (n % 3) + computeSeven; // 나머지를 더하고
            n = n / 3; // 3으로 나눈다.
        }

        // 문자열을 뒤집는다.
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(computeSeven);

        StringBuilder reverse = stringBuilder.reverse();
        String result = reverse.toString();

        // 3진수 문자를 10진수로 변환한다.
        return Integer.parseInt(result, 3);
    }

}
