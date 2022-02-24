package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(solution(str1, str2));
    }

    public static String solution(String str1, String str2) {
        String answer = "YES";

        Map<Character, Integer> map = new HashMap<>();

        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for (char x : str2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }

            map.put(x, map.get(x) - 1);
        }

        return answer;
    }
}
