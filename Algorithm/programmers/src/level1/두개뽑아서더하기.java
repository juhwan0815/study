package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 두개뽑아서더하기 {

    public static void main(String[] args) {
        solution(new int[]{2, 1, 3, 4, 1});
    }

    public static int[] solution(int[] numbers) {
        List<Integer> numList = new ArrayList<>();

        // 배열을 돌면서 정수끼리 더한값이 리스트에 있는지 확인하고 없으면 넣는다.
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (!numList.contains(numbers[i] + numbers[j])) {
                    numList.add(numbers[i] + numbers[j]);
                }
            }
        }

        // 리스트를 정렬한다.
        Collections.sort(numList);

        // 리스트의 값을 정수 배열로 반환한다.
        int[] sumArray = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            sumArray[i] = numList.get(i);
        }

        return sumArray;
    }
}
