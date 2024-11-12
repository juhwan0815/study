package level0.java;

public class 공배수 {

    public static void main(String[] args) {
        int solution = solution(60, 2, 3);
        System.out.println(solution);
    }

    public static int solution(int number, int n, int m) {
        return (number % n == 0 && number % m == 0) ? 1 : 0;
    }
}
