package level0;

public class 팩토리얼 {

    public static void main(String[] args) {
        solution(3628800);
    }

    public static int solution(int n) {
        int answer = 0;
        int pos = 1;

        while(true) {
            int temp = 1;

            for(int i = 1; i <= pos; i++) {
                temp *= i;
            }

            if(temp > n) {
                break;
            }

            pos++;
        }

        answer = pos - 1;
        return answer;
    }

}
