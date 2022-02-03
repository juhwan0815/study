package level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 프린터 {

    public static void main(String[] args) {
//        solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
        solution(new int[]{2, 1, 3, 2}, 2);
    }

    public static int solution(int[] priorities, int location) {
        // 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지 추적하는 변수
        int myLocation = location;
        int count = 0;

        // 중요도 리스트
        List<Integer> prioritiesList = new ArrayList<>();

        // 프린트 큐
        List<Integer> printQueue = new ArrayList<>();

        for (int priority : priorities) {
            prioritiesList.add(priority);
            printQueue.add(priority);
        }

        // 중요도가 높은 순으로 정렬
        Collections.sort(prioritiesList, Collections.reverseOrder());

        // 계속 돌면서
        while (printQueue.size() > 0) {

            // 맨 앞에 있는 게 중요도가 높은지 낮은 지 확인
            if (prioritiesList.get(0) > printQueue.get(0)) {
                // 중요도가 낮다면 뒤로 이동한다.
                printQueue.add(printQueue.remove(0));
                // 맨앞이면 맨 뒤로
                if (myLocation == 0) {
                    myLocation = printQueue.size() - 1;
                } else {
                    // 아니면 그냥 뺀다.
                    myLocation--;
                }
            } else {
                // 중요도가 낮거나 같다면 뺀다
                prioritiesList.remove(0);
                printQueue.remove(0);
                count++;

                // 위치가 0 이였다면 멈추고
                if(myLocation == 0){
                    break;
                } else {
                    // 아니면 앞으로 땡긴다.
                    myLocation--;
                }

            }
        }

        return count;
    }
}
