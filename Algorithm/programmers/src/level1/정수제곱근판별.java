package level1;

public class 정수제곱근판별 {

    public static void main(String[] args) {
        solution(3);
    }

    public static long solution(long n) {
        // 제곱근
        double squareRoot = Math.sqrt(n);

        // 문자열 변환
        String stringSquareRoot = String.valueOf(squareRoot);

        // . index 찾기
        int index = stringSquareRoot.indexOf(".");

        // . 이후의 문자열
        String decimal = stringSquareRoot.substring(index+1, stringSquareRoot.length());

        // 제곱근이 정수인지 확인 - 소수점자리가 1개 이상인지 판별
        return decimal.length() > 1 ? -1 : (long) Math.pow(squareRoot + 1, 2);
    }
}
