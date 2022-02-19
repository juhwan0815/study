package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 쇠막대기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        List<Character> charList = new ArrayList<>();
        int answer = 0;

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') { // (
                charList.add(charArray[i]);
            } else { // )
                // 1 이상일 때
                if (charArray[i - 1] == ')') {
                    charList.remove(0);
                    answer += 1;
                    continue;
                }

                if (charList.size() > 1) {
                    charList.remove(charList.size() - 1);
                    answer += charList.size();
                } else { // 1 이하일때
                    charList.remove(0); // 그냥 제거
                }
            }
        }


        return answer;
    }
}
