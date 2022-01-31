package level1;

public class 약수의개수와덧셈 {

    public static void main(String[] args) {
        solution(24, 27);
    }

    public static int solution(int left, int right) {
        // 합
        int sum = 0;

        // 왼쪽부터 오른쪽까지 반복
        for (int i = left; i <= right; i++) {
            int count = 0;

            // 약수면 카운트를 증가
            for (int j = 1; j <= i; j++) {
                if ((i % j) == 0) {
                    count++;
                }
            }

            // 약수가 짝수인지 홀수인지 확인
            if ((count % 2) == 0) {
                sum += i;
            } else {
                sum -= i;
            }
        }

        return sum;
    }
}
