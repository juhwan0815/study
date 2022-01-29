package level2;

import java.util.ArrayList;
import java.util.List;

public class N개의최소공배수 {

    public static void main(String[] args) {
        solution(new int[]{2, 6, 8, 14});
        solution(new int[]{1, 2, 3});
    }

    public static int solution(int[] arr) {
        // 정수 리스트
        List<Integer> numList = new ArrayList<>();

        // 리스트에 추가
        for (int num : arr) {
            numList.add(num);
        }

        // 리스트의 사이즈가 1 초과일 때
        while (numList.size() > 1) {
            // 리스트에서 2개를 빼서
            Integer num1 = numList.remove(0);
            Integer num2 = numList.remove(0);
            int biggerNum = 0;

            if (num2 > num1) {
                biggerNum = num2;
            } else {
                biggerNum = num1;
            }

            // 최소공배수를 구한다.
            for (int i = biggerNum; i >= biggerNum; i++) {
                if ((i % num1) == 0 && (i % num2) == 0) {
                    // 최소 공배수가 구해지면 리스트에 넣는다.
                    numList.add(i);
                    break;
                }
            }
        }

        return numList.remove(0);
    }

}
