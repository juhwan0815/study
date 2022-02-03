package string;

import java.util.Scanner;

public class 암호 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        System.out.println(solution(str, n));
    }

    /**
     * replace(old, new) 메서드를 활용하여 문자 변환
     * Integer.parseInt(문자열, 진수) 메서드를 활용하여 숫자로 변환
     */
    public static String solution(String str, int n) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7).replace('*', '0').replace('#', '1');
            str = str.substring(7);

            answer += (char) Integer.parseInt(temp, 2);
        }

        return answer;
    }
}
