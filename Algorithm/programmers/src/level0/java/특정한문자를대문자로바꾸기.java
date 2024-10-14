package level0.java;

public class 특정한문자를대문자로바꾸기 {

    public static void main(String[] args) {
        String solution = solution("programmers", "p");
        System.out.println(solution);
    }

    public static String solution(String my_string, String alp) {
        return my_string.replaceAll(alp, alp.toUpperCase());
    }

}
