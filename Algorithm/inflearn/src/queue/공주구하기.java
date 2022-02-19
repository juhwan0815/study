package queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 공주구하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        // 왕자들 넣기
        List<Integer> princes = new ArrayList<>();
        int start = -1;

        for (int i = 1; i <= n; i++) {
            princes.add(i);
        }

        while (princes.size() > 1) {
            for (int i = 0; i < k; i++) {
                start++;
                if(start > princes.size()-1){
                    start = 0;
                }
            }

            princes.remove(start);
            start--;
        }


        return princes.remove(0);
    }
}
