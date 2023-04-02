package level0;

import java.util.ArrayList;

public class 짝수는싫어요 {

    public static void main(String[] args) {
        solution(15);
    }

    public static int[] solution(int n) {
        int length = (n % 2) == 0 ? (n / 2) : (n / 2) + 1;
        int[] answer = new int[length];
        int pos = 0;

        for(int i = 1; i <= n; i++) {
            if((i % 2) == 1) {
                answer[pos] = i;
                pos++;
            }
        }

        return answer;
    }

}
