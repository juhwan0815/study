package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {

    public static void main(String[] args) {
        solution(new int[]{5, 9, 7, 10}, 5);
        solution(new int[]{2, 36, 1, 3}, 1);
        solution(new int[]{3, 2, 6}, 10);

    }

    public static int[] solution(int[] arr, int divisor) {
        // 나누어 떨어지는 정수를 리스트에 넣는다.
        List<Integer> successList = new ArrayList<>();
        for (int num : arr) {
            if ((num % divisor) == 0) {
                successList.add(num);
            }
        }

        // 리스트를 정렬한다.
        Collections.sort(successList);

        // 리스트의 사이즈가 0이면 [-1] 반환 아니면 옮긴다.
        int[] result = null;
        if (successList.size() == 0) {
            result = new int[]{-1};
        } else {
            result = new int[successList.size()];
            for (int i = 0; i < successList.size(); i++) {
                result[i] = successList.get(i);
            }
        }
        return result;
    }

}
