package level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        solution(new int[]{4,4,4,3,3});
    }

    public static int[] solution(int[] arr) {
        // 정수를 저장하기 위한 리스트 선언
        List<Integer> numList = new ArrayList<>();
        // 리스트에 마지막 정수가 들어가 있는 위치
        int currentIndex = 0;

        for (int num : arr) {
            // 리스트가 비어있을 경우 바로 넣는다.
            if (numList.size() == 0) {
                numList.add(num);
                continue;
            }

            // 비어있지 않은 경우 현재 리스트의 마지막에 들어가 있는 정수가 현재 정수와 같다면 패스하고 아니면 리스트에 넣고 위치를 ++
            if (numList.get(currentIndex) == num) {
                continue;
            } else {
                numList.add(num);
                currentIndex++;
            }
        }

        // 리스트에 있는 정수를 배열로 옮긴다.
        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }

        return result;
    }
}

