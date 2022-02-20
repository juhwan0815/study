package searching;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LRU {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i : solution(s, n, arr)) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int s, int n, int[] arr) {
        List<Integer> cache = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!cache.contains(arr[i])) {
                cache.add(0,arr[i]);
            } else {
                int index = cache.indexOf(arr[i]);
                cache.remove(index);
                cache.add(0,arr[i]);
            }
        }

        int[] cacheArr = new int[s];
        for (int i = 0; i < s; i++) {
            cacheArr[i] = cache.get(i);
        }

        return cacheArr;
    }

}


