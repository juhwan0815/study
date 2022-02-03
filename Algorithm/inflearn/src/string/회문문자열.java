package string;

import java.util.Scanner;

public class 회문문자열 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution1(str));
    }

    /**
     * StringBuilder 를 사용하여 뒤집기
     * equalsIgnoreCase() 를 사용하여 대소문자 구분 X
     */
    public static String solution1(String str) {
        String answer = "NO";

        String reverseStr = new StringBuilder(str).reverse().toString();
        if (str.equalsIgnoreCase(reverseStr)) {
            answer = "YES";
        }

        return answer;
    }


    /**
     * 문자열 한개한개를 매칭하는 방법
     */
    public static String solution2(String str) {
        String answer = "YES";
        str = str.toUpperCase();

        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            // 앞과 뒤를 한개씩 이동하면서 매칭
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                return "NO";
            }
        }

        return answer;
    }
}
