package level0.java;

public class 대문자로바꾸기 {

    public static void main(String[] args) {
        String solution = solution("aBcDeFg");
        System.out.println(solution);
    }

    public static String solution(String myString) {
        return myString.toUpperCase();
    }

}
