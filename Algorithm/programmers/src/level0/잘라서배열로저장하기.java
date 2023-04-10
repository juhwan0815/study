package level0;

import java.util.ArrayList;
import java.util.List;

public class 잘라서배열로저장하기 {

    public static void main(String[] args) {
        solution("abc1Addfggg4556b", 6);
    }

    public static String[] solution(String my_str, int n) {
        String[] answer = {};

        List<String> strList = new ArrayList<>();

        while(true) {
            if(my_str.length() >= n) {
                strList.add(my_str.substring(0, n));
                my_str = my_str.substring(n);
            } else {
                if(my_str.length() > 0) {
                    strList.add(my_str);
                }
                break;
            }
        }

        answer = strList.toArray(new String[strList.size()]);

        return answer;
    }
}
