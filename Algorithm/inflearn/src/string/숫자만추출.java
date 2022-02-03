package string;

import java.util.Scanner;

public class 숫자만추출 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution2(str));
    }

    /**
     * ASCII 코드를 이용한 풀이
     */
    public static int solution1(String str) {
        int answer = 0;

        for (char c : str.toCharArray()) {
            if (c >= 48 && c <= 57) { // 0 ~ 9 숫자
                answer = answer * 10 + (c - 48);
            }
        }

        return answer;
    }

    /**
     * Character.isDigit() 메서드를 이용한 풀이
     */
    public static int solution2(String str) {
        String answer = "";

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                answer += c;
            }
        }

        return Integer.parseInt(answer);
    }
}


