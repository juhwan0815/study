package level0;

public class 피자나눠먹기1 {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {
        int answer = (n % 7) > 0 ? (n / 7) + 1 : (n / 7);
        return answer;
    }
}
