package string;

import java.util.Scanner;

public class 중복문자제거 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            // i번째 문자가 문자열에서 처음 발견되는 위치가 i와 같다면 처음 발견되는 문자라는 것
            if (str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
            }
        }

        return answer;
    }
}
