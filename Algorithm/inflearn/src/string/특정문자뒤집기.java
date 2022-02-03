package string;

import java.util.Scanner;

public class 특정문자뒤집기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        char[] charArray = str.toCharArray();
        int lt = 0;
        int rt = charArray.length - 1;

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }

        answer = String.valueOf(charArray);
        return answer;
    }

}
