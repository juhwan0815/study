package level0;
import java.util.*;

public class 약수구하기 {

    public static void main(String[] args) {
        solution(29);
    }

    public static int[] solution(int n) {
        int[] answer = {};

        List<Integer> numList = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if((n % i) == 0) {
                numList.add(i);
            }
        }

        answer = numList.stream()
                .mapToInt(i -> i)
                .toArray();

        return answer;
    }

}

