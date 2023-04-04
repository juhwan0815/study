package level0;

import java.util.*;
public class 중복된문자제거 {

    public static void main(String[] args) {
        solution("We are the world");
    }

    public static String solution(String my_string) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        List<String> strList = new ArrayList<>();

        char[] chars = my_string.toCharArray();

        for(char c : chars) {
            String s = String.valueOf(c);

            if(!strList.contains(s)) {
                strList.add(s);
            }
        }

        for(String s : strList) {
            sb.append(s);
        }

        answer = sb.toString();
        return answer;
    }

}
