package string;

import java.util.ArrayList;
import java.util.Scanner;

public class 단어뒤집기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = scanner.next();
        }

        ArrayList<String> strList = solution(n, strArray);
        for (String str : strList) {
            System.out.println(str);
        }

    }

    /**
     * 직접 뒤집기
     */
    public static ArrayList<String> solution(int n, String[] strArray) {
        ArrayList<String> answer = new ArrayList<>();
        for (String str : strArray) {
            char[] charArray = str.toCharArray();

            int lt = 0;
            int rt = charArray.length - 1;

            while (lt < rt) {
                char tmp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = tmp;
                lt++;
                rt--;
            }

            String tmp = String.valueOf(charArray);
            answer.add(tmp);
        }
        return answer;
    }

    /**
     * StringBuilder 를 사용
     */
//    public static ArrayList<String> solution(int n, String[] strArray) {
//        ArrayList<String> answer = new ArrayList<>();
//        for (String str : strArray) {
//            String reverseStr = new StringBuilder(str).reverse().toString();
//            answer.add(reverseStr);
//        }
//
//        return answer;
//    }
}
