package level0.java;

public class 문자열의앞의n글자 {

    public static void main(String[] args) {
        String solution = solution("ProgrammerS123", 11);
        System.out.println(solution);
    }

    public static String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}
