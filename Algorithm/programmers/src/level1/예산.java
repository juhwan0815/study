package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 예산 {

    public static void main(String[] args) {
        solution(new int[]{1, 3, 2, 5, 4}, 9);
    }

    public static int solution(int[] d, int budget) {
        // 정렬을 위해 List 생성
        List<Integer> numList = new ArrayList<>();
        for (int num : d) {
            numList.add(num);
        }

        // 정렬
        Collections.sort(numList);

        // 예산에서 빼준다.
        int count = 0;
        for (Integer num : numList) {
            // 만약 예산을 오버하려고하면 멈춘다.
            if(budget - num < 0){
                break;
            }
            budget -= num;
            count++;
        }

        return count;
    }
}
