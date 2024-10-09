package level0.java;

public class 문자리스트를문자열로변환하기 {

    public static void main(String[] args) {
        String solution = solution(new String[]{"a", "b", "c"});
        System.out.println(solution);
    }

    public static String solution(String[] arr) {
        return String.join("", arr);
    }
}
