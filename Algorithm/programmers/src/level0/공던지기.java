package level0;

import java.util.ArrayList;
import java.util.List;

public class 공던지기 {

    public static void main(String[] args) {
        solution(new int[]{1,2,3,4}, 2);
    }

    public static int solution(int[] numbers, int k) {
        int answer = 0;

        List<Integer> circle = new ArrayList<>();

        for(int n : numbers) {
            circle.add(n);
        }

        int num = circle.remove(0);
        circle.add(num);

        while(true) {
            int num1 = circle.remove(0);
            int num2 = circle.remove(0);

            circle.add(num1);
            circle.add(num2);

            k--;

            if(k == 1) {
                answer = num2;
                break;
            }
        }

        return answer;
    }

}
