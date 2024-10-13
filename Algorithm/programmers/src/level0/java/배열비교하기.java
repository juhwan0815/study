package level0.java;

import java.util.Arrays;

public class 배열비교하기 {

    public static void main(String[] args) {
        int solution = solution(new int[]{49, 13}, new int[]{70, 11, 2});
        System.out.println(solution);
    }

    public static int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) {
            return 1;
        } else if (arr1.length < arr2.length) {
            return -1;
        } else {
            int arr1Sum = Arrays.stream(arr1)
                    .sum();

            int arr2Sum = Arrays.stream(arr2)
                    .sum();

            if (arr1Sum > arr2Sum) {
                return 1;
            } else if (arr1Sum < arr2Sum) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
