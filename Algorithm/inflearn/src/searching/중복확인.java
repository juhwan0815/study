package searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 중복확인 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print(solution(n, arr));
    }

    public static char solution(int n, int[] arr) {
        char answer = 'U';

        List<Integer> repository = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (repository.contains(arr[i])) {
                answer = 'D';
                break;
            } else {
                repository.add(arr[i]);
            }
        }

        return answer;
    }
}
