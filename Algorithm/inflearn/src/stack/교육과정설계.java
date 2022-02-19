package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 교육과정설계 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(solution(s1, s2));
    }

    public static String solution(String s1, String s2) {
        String answer = "YES";

        List<Character> plan = new ArrayList<>();
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            plan.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == plan.get(0)) {
                plan.remove(0);
                if (plan.size() == 0) {
                    break;
                }
            }
        }

        if (plan.size() > 0) {
            answer = "NO";
        }

        return answer;
    }
}
