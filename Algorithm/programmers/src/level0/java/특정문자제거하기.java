package level0.java;

public class 특정문자제거하기 {

    public static void main(String[] args) {
        String solution = solution("abcdef", "f");
        System.out.println(solution);
    }

    public static String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}
