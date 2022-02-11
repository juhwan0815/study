package hashmap;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class K번째큰수 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int s = j + 1; s < n; s++) {
                    int sum = arr[i] + arr[j] + arr[s];
                    set.add(sum);
                }
            }
        }

        int i = 0;
        for (Integer num : set) {
            if (set.size() - k < 0) {
                answer = -1;
                break;
            }
            if (i == set.size() - k) {
                answer = num;
            }
            i++;
        }

        return answer;
    }
}
