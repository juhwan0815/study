package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 응급실 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        List<Integer> queue = new ArrayList<>();
        int answer = 0;
        // 다 집어 넣기
        for (int i = 0; i < n; i++) {
            queue.add(arr[i]);
        }

        int position = m;

        // 반복한다.
        while (true) {
            boolean check = false;
            for (int i = 1; i < queue.size(); i++) {
                if (queue.get(i) > queue.get(0)) {
                    check = true;
                    break;
                }
            }


            if (check) {
                Integer num = queue.remove(0);
                queue.add(num);
                if (position == 0) {
                    position = queue.size() - 1;
                } else {
                    position--;
                }
            } else {
                queue.remove(0);
                answer++;
                if (position == 0) {
                    break;
                } else {
                    position--;
                }
            }
        }

        return answer;
    }
}
