package level0.java;

public class rny_string {

    public static void main(String[] args) {
        String solution = solution("programmers");
        System.out.println(solution);
    }

    public static String solution(String rny_string) {
        return rny_string.replaceAll("m","rn");
    }

}
