package level2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

    public static void main(String[] args) {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
//        solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        List<Integer> queue = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int current = 0;

        for (int progress : progresses) {
            queue.add(progress);
        }

        while (current < queue.size()) {
            int count = 0;

            for (int i = 0; i < progresses.length; i++) {
                Integer progress = queue.remove(i);
                queue.add(i, progress + speeds[i]);
            }

            if (queue.get(count) >= 100) {
                for (int i = current; i < queue.size(); i++) {
                    if (queue.get(i) >= 100) {
                        count++;
                        current++;
                    } else {
                        break;
                    }
                }
            }

            if (count > 0) {
                result.add(count);
            }
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
