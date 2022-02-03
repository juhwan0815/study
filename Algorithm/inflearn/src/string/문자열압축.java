package string;

import java.util.Scanner;

public class 문자열압축 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    /**
     * --> 방향으로 가면서 다음 인덱스의 값과 비교
     * 배열의 크기를 넘어갈 수 있으므로 공백을 추가하고 for 문의 횟수를 한번 감소
     */
    public static String solution(String str) {
        String answer = "";
        str = str + " ";
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                answer += str.charAt(i);
                if (count > 1) {
                    answer += String.valueOf(count);
                }

                count = 1;
            }
        }

        return answer;
    }
}
