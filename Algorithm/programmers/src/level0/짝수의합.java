package level0;

public class 짝수의합 {

    public static void main(String[] args) {
        solution(10);
    }

    public static int solution(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

}
