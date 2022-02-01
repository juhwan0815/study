package level2;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {

    public static void main(String[] args) {
        solution(new String[]{"119", "97674223", "1195524421"});
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // 각 문자열을 키로 하여 해시맵에 집어넣는다.
        Map<String, Integer> repository = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            repository.put(phone_book[i], i);
        }

        // 배열을 돌면서
        // 문자를 잘라내는 크기를 늘려가면서 해시 키가 존재하는지 확인한다.
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                String str = phone_book[i].substring(0, j);
                if(repository.containsKey(str)){
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
