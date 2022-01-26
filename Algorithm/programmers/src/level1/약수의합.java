package level1;

public class 약수의합 {

    public static void main(String[] args) {
        solution(5);
    }

    public static int solution(int n) {
        int sum = 0;

        // 나머지 연산을 했을 때 0 인 숫자를 더한다.
        for (int i = 1; i <= n; i++) {
            if((n % i) == 0){
                sum += i;
            }
        }

        return sum;
    }
}
