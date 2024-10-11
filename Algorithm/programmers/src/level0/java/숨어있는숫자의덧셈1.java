package level0.java;

public class 숨어있는숫자의덧셈1 {

    public static void main(String[] args) {
        int solution = solution("aAb1B2cC34oOp");
        System.out.println(solution);
    }

    public static int solution(String my_string) {
        return my_string.chars()
                .mapToObj(value -> (char) value)
                .filter(Character::isDigit)
                .mapToInt(value -> Integer.parseInt(String.valueOf(value)))
                .sum();
    }
}
