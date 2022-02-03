package string;

import java.util.Scanner;

public class 문장속단어 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String str) {
        String answer = "";

        String[] strArray = str.split(" ");
        int pos = Integer.MIN_VALUE;
        int m = 0;

        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }

        if (str.length() > m) {
            answer = str;
        }

        // split
//        for (String s : strArray) {
//            if (s.length() > answer.length()) {
//                answer = s;
//            }
//        }

        return answer;
    }

}
