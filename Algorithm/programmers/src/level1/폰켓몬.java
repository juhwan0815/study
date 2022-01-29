package level1;

import java.util.ArrayList;
import java.util.List;

public class 폰켓몬 {

    public static void main(String[] args) {
        solution(new int[]{3, 3, 3, 2, 2, 4, 5, 6});
    }

    public static int solution(int[] nums) {
        // 가져갈수 잇는 개수
        int carryNum = nums.length / 2;

        // 중복을 걸러낸다. -> 종류를 찾아낸다.
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!numList.contains(nums[i])) {
                numList.add(nums[i]);
            }
        }

        // 종류의 개수가 가져갈 수 있는 개수보다 많으면 가져갈수있는 개수를 반환
        if (numList.size() > carryNum) {
            return carryNum;
        } else {
            // 같다면 그냥 종료의 개수를 반환
            return numList.size();
        }
    }
}
