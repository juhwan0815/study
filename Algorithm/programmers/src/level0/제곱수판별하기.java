package level0;

public class 제곱수판별하기 {

    public static void main(String[] args) {
        solution(144);
    }

    public static int solution(int n) {
        int answer = Math.sqrt(n) % 1 == 0 ? 1 : 2;
        return answer;
    }
}
