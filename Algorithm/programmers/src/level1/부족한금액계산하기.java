package level1;

public class 부족한금액계산하기 {

    public static void main(String[] args) {
        solution(3, 20, 4);
    }

    public static long solution(int price, int money, int count) {
        long sum = 0;

        // 이용할때마다의 금액을 더한다.
        for (int i = 0; i < count; i++) {
            sum += price * (i + 1);
        }

        // 소지 금액과 비교한다.
        if (sum < money) {
            return 0;
        } else {
            return sum - money;
        }
    }
}
