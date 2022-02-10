package hashmap;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class 모든아나그램찾기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        System.out.println(solution(s, t));
    }

    public static int solution(String s, String t) {
        Map<Character, Integer> sRepository = new HashMap<>();
        Map<Character, Integer> tRepository = new HashMap<>();

        int answer = 0;

        s = s.toLowerCase();
        t = t.toLowerCase();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < t.length(); i++) {
            if (sRepository.containsKey(sArr[i])) {
                Integer num = sRepository.get(sArr[i]);
                sRepository.put(sArr[i], ++num);
            } else {
                sRepository.put(sArr[i], 1);
            }

            if (tRepository.containsKey(tArr[i])) {
                Integer num = tRepository.get(tArr[i]);
                tRepository.put(tArr[i], ++num);
            } else {
                tRepository.put(tArr[i], 1);
            }
        }

        boolean check = true;
        for (char x : tRepository.keySet()) {
            if (!tRepository.get(x).equals(sRepository.get(x))) {
                check = false;
            }
        }

        if (check) {
            answer++;
        }

        for (int i = 0; i + t.length() < s.length(); i++) {
            Integer num = sRepository.get(sArr[i]);
            if (num == 1) {
                sRepository.remove(sArr[i]);
            } else if (num > 1) {
                sRepository.put(sArr[i], num - 1);
            }

            if (sRepository.containsKey(sArr[i + t.length()])) {
                Integer num1 = sRepository.get(sArr[i + t.length()]);
                sRepository.put(sArr[i + t.length()], num1 + 1);
            } else {
                sRepository.put(sArr[i + t.length()], 1);
            }

            boolean check1 = true;
            for (char x : tRepository.keySet()) {
                if (!tRepository.get(x).equals(sRepository.get(x))) {
                    check1 = false;
                }
            }

            if (check1) {
                answer++;
            }
        }

        return answer;
    }
}
