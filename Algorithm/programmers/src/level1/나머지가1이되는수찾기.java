package level1;

public class 나머지가1이되는수찾기 {

    public static void main(String[] args) {
        solution(12);
    }

    public static int solution(int n) {
        int answer = 0;

        // 제일 처음 나머지가 1인 숫자를 찾는다.
        for (int i = 1; i < n; i++) {
            if ((n % i) == 1) {
               answer = i;
               break;
            }
        }

        return answer;
    }
}
