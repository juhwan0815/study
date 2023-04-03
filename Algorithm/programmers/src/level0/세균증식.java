package level0;

public class 세균증식 {

    public static void main(String[] args) {
        solution(2, 10);
    }

    public static int solution(int n, int t) {
        int answer = 0;

        for(int i = 0; i < t; i++) {
            n = 2 * n;
        }

        answer = n;
        return answer;
    }
}
