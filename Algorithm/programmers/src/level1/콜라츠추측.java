package level1;

public class 콜라츠추측 {

    public static void main(String[] args) {
        solution(626331);
    }

    public static int solution(int num) {
        int answer = 0;
        long copyNum = num;

        // 1이 될때까지 반복
        while (copyNum != 1) {
            // 500 이면 -1
            if (answer == 500) {
                answer = -1;
                break;
            }

            answer++;

            // 짝수/홀수
            if ((copyNum % 2) == 0) {
                copyNum = copyNum / 2;
            } else {
                copyNum = 3 * copyNum + 1;
            }
        }

        return answer;
    }
}
