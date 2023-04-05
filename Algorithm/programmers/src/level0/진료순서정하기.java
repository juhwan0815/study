package level0;

import java.util.Arrays;
import java.util.Collections;

public class 진료순서정하기 {

    public static void main(String[] args) {
        solution(new int[] {3, 76, 24});
    }

    public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];

        Integer[] copyArray = new Integer[emergency.length];

        for(int i = 0; i < emergency.length; i++) {
            copyArray[i] = emergency[i];
        }

        Arrays.sort(copyArray, Collections.reverseOrder());

        for(int i = 0; i < copyArray.length; i++) {

            for(int j = 0; j < emergency.length; j++) {
                if(copyArray[i] == emergency[j]) {
                    answer[j] = i+1;
                    break;
                }
            }
        }

        return answer;
    }

}
