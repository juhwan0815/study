package level0;

import java.util.ArrayList;
import java.util.List;

public class N의배수고르기 {

    public static void main(String[] args) {
        solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
    }

    public static int[] solution(int n, int[] numlist) {
        int[] answer = {};
        List<Integer> numList = new ArrayList<>();

        for(int num : numlist) {
            if(num % n == 0) {
                numList.add(num);
            }
        }

        answer = numList.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}
