package level0;

public class 양꼬치 {

    public static void main(String[] args) {
        solution(10, 3);
    }

    public static int solution(int n, int k) {
        int answer = 0;

        int service = n / 10;

        answer += (n * 12000);
        answer += k > 0 ? (k-service) * 2000 : 0;
        return answer;
    }

}
