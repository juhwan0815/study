package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class 배열뒤집기 {

    public static void main(String[] args) {
        solution(new int[]{1, 0, 1, 1, 1, 3, 5});
    }

    public static int[] solution(int[] num_list) {

        int[] reverse = new int[num_list.length];

        for(int i = 0; i < num_list.length; i++) {
            reverse[num_list.length - (i+1)] = num_list[i];
        }

        return reverse;
    }
}
