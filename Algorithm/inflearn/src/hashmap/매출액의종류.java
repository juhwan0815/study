package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 매출액의종류 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int x : solution(n, k, arr)) {
            System.out.print(x + " ");
        }
    }

    public static int[] solution(int n, int k, int[] arr) {
        int[] answer = new int[n - k + 1];

        Map<Integer, Integer> repository = new HashMap<>();

        for (int i = 0; i < k; i++) {
            if (repository.containsKey(arr[i])) {
                Integer back = repository.get(arr[i]);
                repository.put(arr[i], back + 1);
            } else {
                repository.put(arr[i], 1);
            }

        }
        answer[0] = repository.keySet().size();

        for (int i = 0; i + k < n; i++) {
            // front 를 빼고
            Integer front = repository.get(arr[i]);
            if (front == 1) {
                repository.remove(arr[i]);
            } else if (front > 1) {
                repository.put(arr[i], front - 1);
            }

            // back 넣는다.
            if (repository.containsKey(arr[i + k])) {
                Integer back = repository.get(arr[i + k]);
                repository.put(arr[i + k], back + 1);
            } else {
                repository.put(arr[i + k], 1);
            }

            answer[i + 1] = repository.keySet().size();
        }

        return answer;
    }
}

