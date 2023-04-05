package level0;

import java.util.*;

public class 한번만등장한문자 {

    public static void main(String[] args) {
        solution("abcabcadc");
    }

    public static String solution(String s) {
        String answer = "";

        char[] chars = s.toCharArray();

        StringBuffer sb = new StringBuffer();

        Map<String, Integer> storage = new HashMap();

        for(char c : chars) {
            String str = String.valueOf(c);

            if(storage.get(str) == null) {
                storage.put(str, 1);
            } else {
                int count = storage.get(str);
                count++;
                storage.put(str,count);
            }
        }

        for(String key : storage.keySet()) {

            int count = storage.get(key);
            if(count == 1) {
                sb.append(key);
            }
        }

        String answerStr = sb.toString();

        if(answerStr.length() == 0) {
            answer = "";
        } else {
            char[] charArray = answerStr.toCharArray();
            Arrays.sort(charArray);
            answer = String.valueOf(charArray);
        }

        return answer;
    }
}
