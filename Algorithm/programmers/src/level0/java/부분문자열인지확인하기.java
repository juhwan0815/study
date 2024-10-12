package level0.java;

public class 부분문자열인지확인하기 {

    public static void main(String[] args) {
        int solution = solution("banana", "ana");
        System.out.println(solution);
    }

    public static int solution(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
}
