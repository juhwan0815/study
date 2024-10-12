package level0.java;

public class 문자열을정수로변환하기 {

    public static void main(String[] args) {
        int solution = solution("10");
        System.out.println(solution);
    }

    public static int solution(String n_str) {
        return Integer.parseInt(n_str);
    }
}
