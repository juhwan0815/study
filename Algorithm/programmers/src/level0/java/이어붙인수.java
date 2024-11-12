package level0.java;

public class 이어붙인수 {

    public static void main(String[] args) {
        int solution = solution(new int[]{3, 4, 5, 2, 1});
        System.out.println(solution);
    }

    public static int solution(int[] num_list) {
        StringBuilder evenSum = new StringBuilder();
        StringBuilder oddSum = new StringBuilder();

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 0) {
                evenSum.append(num_list[i]);
            } else {
                oddSum.append(num_list[i]);
            }
        }

        return Integer.parseInt(evenSum.toString()) + Integer.parseInt(oddSum.toString());
    }
}
