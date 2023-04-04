package level0;

public class 피자나눠먹기2 {

    public static void main(String[] args) {
        solution(10);
    }

    public static int solution(int n) {
        int answer = 0;

        while(true) {
            answer++;

            if(((6 * answer) % n) == 0) {
                break;
            }
        }

        return answer;
    }

}
