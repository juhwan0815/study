package level0.java;

public class 배열의길이에따라다른연산하기 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{49, 12, 100, 276}, 27);
        System.out.println(solution);
    }

    public static int[] solution(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length % 2 == 0) {
                if (i % 2 != 0) {
                    arr[i] += n;
                }
            } else {
                if (i % 2 == 0) {
                    arr[i] += n;
                }
            }
        }
        return arr;
    }
}
