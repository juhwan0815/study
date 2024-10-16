package level0.java;

public class 접두사인지확인하기 {

    public static void main(String[] args) {
        int solution = solution("banana", "ban");
        System.out.println(solution);
    }

    public static int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}

