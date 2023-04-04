package level0;

import java.util.ArrayList;
import java.util.List;

public class 배열회전시키기 {

    public static void main(String[] args) {
        solution(new int[] {4, 455, 6, 4, -1 , 45, 6},"left");
    }

    public static int[] solution(int[] numbers, String direction) {
        int[] answer = {};

        List<Integer> numList = new ArrayList<>();

        for(int i = 0; i < numbers.length; i++) {
            numList.add(numbers[i]);
        }

        if("right".equals(direction)) {
            Integer temp = numList.remove(numList.size() - 1);
            numList.add(0, temp);
        } else {
            Integer temp = numList.remove(0);
            numList.add(temp);
        }

        answer = numList.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }
}
