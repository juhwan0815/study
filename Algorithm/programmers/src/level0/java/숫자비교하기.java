package level0.java;

public class 숫자비교하기 {

    public static void main(String[] args) {
        int solution = solution(7, 99);
        System.out.println(solution);
    }

    public static int solution(int num1, int num2) {
        return num1 == num2 ? 1 : -1;
    }
}
