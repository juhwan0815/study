package level2;

public class 피보나치수 {

    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        return (solution(n-2) % 1234567 + solution(n-1) % 1234567) % 1234567;
    }
}
