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
        Map<String, Integer> repository1 = new HashMap<>();
        Map<String, Integer> repository2 = new HashMap<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        for (int i = 0; i < charArray1.length; i++) {
            if (repository1.containsKey(String.valueOf(charArray1[i]))) {
                int num = repository1.get(String.valueOf(charArray1[i]));
                repository1.put(String.valueOf(charArray1[i]), ++num);
            } else {
                repository1.put(String.valueOf(charArray1[i]), 1);
            }

            if (repository2.containsKey(String.valueOf(charArray2[i]))) {
                int num = repository2.get(String.valueOf(charArray2[i]));
                repository2.put(String.valueOf(charArray2[i]), ++num);
            } else {
                repository2.put(String.valueOf(charArray2[i]), 1);
            }
        }

        String answer = "YES";
        for (String s : repository1.keySet()) {
            if(!repository1.get(s).equals(repository2.get(s))){
                answer = "NO";
                break;
            }
        }

        return answer;
    }
}
