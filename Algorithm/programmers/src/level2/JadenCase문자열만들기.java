package level2;


import java.util.ArrayList;
import java.util.List;

public class JadenCase문자열만들기 {

    public static void main(String[] args) {
//        solution("3people unFollowed me");
        solution(" adgagd 3eagdag ");
        solution("a a a a  a a a a a a ");
    }

    public static String solution(String s) {
        String answer = "";
        String[] sArr = s.toLowerCase().split("");
        boolean check = true;

        for (String s1 : sArr) {
            answer += check ? s1.toUpperCase() : s1;
            check = s1.equals(" ") ? true : false;
        }

        return answer;
    }
}
