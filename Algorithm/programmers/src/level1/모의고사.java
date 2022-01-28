package level1;

import java.util.ArrayList;
import java.util.List;

public class 모의고사 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5});
    }

    public static int[] solution(int[] answers) {
        // 맞춘 횟수 배열
        int manCount[] = new int[3];

        // 패턴
        int[] man1 = {1, 2, 3, 4, 5};
        int[] man2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] man3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // 맞췃는지 틀렷는지 확인
        for (int i = 0; i < answers.length; i++) {
            if (man1[i % man1.length] == answers[i]) {
                manCount[0]++;
            }

            if (man2[i % man2.length] == answers[i]) {
                manCount[1]++;
            }

            if (man3[i % man3.length] == answers[i]) {
                manCount[2]++;
            }
        }

        // 최대 맞춘 횟수를 찾아낸다.
        int maxCount = 0;
        for (int i = 0; i < 3; i++) {
            if (manCount[i] > maxCount) {
                maxCount = manCount[i];
            }
        }

        // 최대 맞춘 횟수인 사람을 골라낸다.
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            if (manCount[i] == maxCount) {
                resultList.add(i + 1);
            }
        }

        // 리스트를 배열로 변환
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }
}
