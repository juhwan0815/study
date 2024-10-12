package level0.java;

public class 문자열정수의합 {

    public static void main(String[] args) {
        int solution = solution("123456789");
        System.out.println(solution);
    }

    public static int solution(String num_str) {
        return num_str.chars()
                .map(value -> Integer.parseInt(String.valueOf((char) value)))
                .sum();
    }
}
