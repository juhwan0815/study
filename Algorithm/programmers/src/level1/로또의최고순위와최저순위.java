package level1;

import java.util.ArrayList;
import java.util.List;

public class 로또의최고순위와최저순위 {

    public static void main(String[] args) {
//        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{31, 10, 45, 1, 6, 19});
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        // 0 개수
        int count = 0;
        // 맞춘 개수
        int collectCount = 0;

        List<Integer> winNumList = new ArrayList<>();
        for (int win_num : win_nums) {
            winNumList.add(win_num);
        }

        for (int lotto : lottos) {
            if (lotto == 0) {
                count++;
                continue;
            }
            if (winNumList.contains(lotto)) {
                collectCount++;
            }
        }

        int[] answer = new int[2];
        if ((collectCount + count) < 2) {
            answer[0] = 6;
            answer[1] = 6;
        } else {
            answer[0] = 7 - (collectCount + count);
            answer[1] = 7 - (collectCount);
            if(collectCount == 0){
                answer[1] = 7 - (collectCount) - 1;
            }
        }

        return answer;
    }
}
