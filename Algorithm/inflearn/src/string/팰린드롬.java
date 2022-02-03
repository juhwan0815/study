package string;

import java.util.Scanner;

public class 팰린드롬 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.print(solution(str));
    }

    /**
     * replaceAll(정규식, 바꿀 문자) 은 정규식 사용 가능
     */
    public static String solution(String str) {
        String answer = "NO";
        // A-Z가 아니면 ^는 부정 -> ""로 대체
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reverseStr = new StringBuilder(str).reverse().toString();

        if (str.equals(reverseStr)) {
            answer = "YES";
        }

        return answer;
    }
}
