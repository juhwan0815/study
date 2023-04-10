package level0;

import java.util.ArrayList;
import java.util.List;

public class 소인수분해 {

    public static void main(String[] args) {
        solution(12);
    }

    public static int[] solution(int n) {
        int number = 2;

        List<Integer> numbers = new ArrayList<>();

        while(true) {
            if(number > n) {
                break;
            }


            if((n % number) == 0) {
                n = n / number;

                if(!numbers.contains(number)) {
                    numbers.add(number);
                }
            } else {
                number++;
            }

        }

        int[] answer = numbers.stream()
                .mapToInt(num -> num)
                .toArray();

        return answer;
    }

}
