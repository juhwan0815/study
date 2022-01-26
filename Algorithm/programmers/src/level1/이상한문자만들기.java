package level1;

import java.util.ArrayList;
import java.util.List;

public class 이상한문자만들기 {

    public static void main(String[] args) {
        solution(" try hello world sex ");
    }

    public static String solution(String s) {
        // split(" ", -1)을 통해 공백을 걸러낸다. -1이 붙는 이유는 없으면 앞에 공백이 있다면 " ", "try" 이렇게 된다.
        String[] words = s.split(" ", -1);
        StringBuilder stringBuilder = new StringBuilder();

        // 리스트에서 문자열을 뽑아서 문자 배열로 만든뒤 짝수 홀수 구분후 추가한다.
        for (int i = 0; i < words.length; i++) {
            char[] chars = words[i].toCharArray();
            for (int j = 0; j < words[i].length(); j++) {
                // 짝수면 대문자 홀수면 소문자
                if ((j % 2) == 0) {
                    stringBuilder.append(String.valueOf(chars[j]).toUpperCase());
                } else {
                    stringBuilder.append(String.valueOf(chars[j]).toLowerCase());
                }
            }

            // 마지막인지 확인
            if (i != (words.length - 1)) {
                stringBuilder.append(" ");
            }
        }


        return stringBuilder.toString();
    }
}
