package level0.java;

public class 접미사인지확인하기 {

    public static void main(String[] args) {
        int solution = solution("banana", "ana");
        System.out.println(solution);
    }

    public static int solution(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }
}
