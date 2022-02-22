package level2;

public class 숫자의표현 {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int value = 0;

            for (int j = i; j <= n; j++) {
                value += j;
                if (value == n) {
                    answer++;
                    break;
                } else if (value > n){
                    break;
                }
            }

        }

        return answer;
    }
}
