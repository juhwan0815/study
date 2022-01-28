package level1;

import java.util.*;

public class 문자를내마음대로정렬하기 {

    public static void main(String[] args) {
//        solution(new String[]{"sun", "bed", "car"}, 1);
        solution(new String[]{"abce", "abcd", "cdx"}, 2);
//        solution(new String[]{"abzcd","cdzab","abzfg","abzaa","abzbb","bbzaa"}, 2);
    }

    public static String[] solution(String[] strings, int n) {
        // 문자열 앞에 n 번째 문자를 추가해서 더한다.
        List<String> stringList = new ArrayList<>();
        for (String s : strings) {
            stringList.add(s.charAt(n) + s);
        }

        // 정렬한다. -> 그럼 n 번째가 같더라도 사전순으로 정렬
        Collections.sort(stringList);

        // 정렬된거에서 n 번째 문자 더했던 걸 제외한다.
        for (int i = 0; i < stringList.size(); i++) {
            strings[i] = stringList.get(i).substring(1, stringList.get(i).length());
        }

        return strings;
    }
}
