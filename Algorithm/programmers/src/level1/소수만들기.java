package level1;

import java.util.ArrayList;
import java.util.List;

public class 소수만들기 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5});
    }

    public static int solution(int[] nums) {
        // 소수를 담을 리스트을 만든다.
        List<Integer> numList = new ArrayList<>();

        // 배열을 돌면서 3개의 숫자를 더한다.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean check = true;
                    // 소수인지 판별
                    for (int h = 2; h <= Math.sqrt(sum); h++) {
                        if ((sum % h) == 0) {
                            check = false;
                        }
                    }

                    // 소수면 리스트에 추가
                    if (check) {
                        numList.add(sum);
                    }
                }
            }
        }

        return numList.size();
    }
}
