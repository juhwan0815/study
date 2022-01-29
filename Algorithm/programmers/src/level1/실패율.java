package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 실패율 {

    public static void main(String[] args) {
//        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
        solution(5, new int[]{2, 1, 2, 4, 2, 4, 3, 3});
//        solution(4, new int[]{4,4,4,4,4});
    }

    public static int[] solution(int N, int[] stages) {
        // 유저 수
        int userNum = stages.length;

        // 각 스테이지 실패율 배열
        double[] fail = new double[N];

        // 스테이지 실패율 리스트
        List<Double> failList = new ArrayList<>();

        // 스테이지 배열
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            // 스테이지를 채워넣는다.
            result[i] = i + 1;

            // 실패한사람 수
            int stageUser = 0;

            // 현재 스테이지에 있는 사람을 구한다.
            for (int j = 0; j < stages.length; j++) {
                // i +1 는 스테이지
                if (stages[j] == i + 1) {
                    stageUser++;
                }
            }

            if (stageUser == 0) {
                // 아무도 실패한 사람이 없으면 실패율은 0이다.
                fail[i] = 0.0;
                failList.add(0.0);
            } else {
                // 아니면 실패율 계산
                double failPercentage = (double) stageUser / (double) userNum;
                fail[i] = failPercentage;
                failList.add(failPercentage);
            }
            userNum -= stageUser;
        }

        // 역순으로 정렬
        Collections.sort(failList, Collections.reverseOrder());

        // 실패율 리스트에서 뽑으면서 실패율이 같은 스테이지를 찾아낸다.
        for (int i = 0; i < N; i++) {
            Double failPercentage = failList.get(i);

            for (int j = 0; j < N; j++) {
                if (failPercentage == fail[j]) {
                    // 다음 스테이지를 위해 스테이지 실패율을 -1로 만든다.
                    result[i] = j + 1;
                    fail[j] = -1;
                    break;
                }
            }
        }

        return result;
    }
}
