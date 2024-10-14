package level0.java;

public class 원하는문자열찾기 {

    public static void main(String[] args) {
        int solution = solution("AbCdEfG", "aBc");
        System.out.println(solution);
    }

    public static int solution(String myString, String pat) {
        return myString.toLowerCase().contains(pat.toLowerCase()) ? 1 : 0;
    }

}
