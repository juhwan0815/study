package string;

import java.util.Scanner;

public class 대소문자변환 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c >= 65 && c <= 90) { // 65~90 대문자
                answer += (char) (c - 32); // 소문자로 변환
            } else { // 97~122 소문자
                answer += (char) (c - 32); // 대문자로 변환
            }

//            if (Character.isLowerCase(c)) {
//                answer += Character.toUpperCase(c);
//            } else {
//                answer += Character.toLowerCase(c);
//            }
        }

        return answer;
    }

}
