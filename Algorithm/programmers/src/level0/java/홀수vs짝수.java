package level0.java;

public class 홀수vs짝수 {

    public static void main(String[] args) {
        int solution = solution(new int[]{4, 2, 6, 1, 7, 6});
        System.out.println(solution);
    }

    public static int solution(int[] num_list) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                oddSum += num_list[i];
            } else {
                evenSum += num_list[i];
            }
        }

        return Math.max(oddSum, evenSum);
    }
}
