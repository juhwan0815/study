package level0;

import java.util.Arrays;

public class 삼각형의완성조건 {

    public static void main(String[] args) {
        solution(new int[]{199, 72, 222});
    }

    public static int solution(int[] sides) {
        int answer = 0;

        Arrays.sort(sides);

        answer = sides[2] < (sides[0] + sides[1]) ? 1 : 2;

        return answer;
    }

}
