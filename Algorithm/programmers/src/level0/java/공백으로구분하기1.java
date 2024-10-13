package level0.java;

public class 공백으로구분하기1 {

    public static void main(String[] args) {
        String[] solution = solution("i love you");
        System.out.println(solution);
    }

    public static String[] solution(String my_string) {
        return my_string.split(" ");
    }

}
