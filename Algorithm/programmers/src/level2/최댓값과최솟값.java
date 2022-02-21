package level2;

import java.util.Arrays;

public class 최댓값과최솟값 {

    public static void main(String[] args) {
        solution("1 2 3 4");
    }

    public static String solution(String s) {
        String[] arr = s.split(" ");
        int[] iArr = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            iArr[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(iArr);

        return iArr[0] + " " + iArr[iArr.length-1];
    }
}
