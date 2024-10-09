package level0.java;

public class 두수의연산값비교하기 {

    public static void main(String[] args) {
        int solution = solution(2, 91);
        System.out.println(solution);
    }

    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(String.valueOf(a).concat(String.valueOf(b))), 2 * a * b);
    }
}
