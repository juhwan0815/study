package level0.java;

public class n보다커질때까지더하기 {

    public static void main(String[] args) {
        int solution = solution(new int[]{34, 5, 71, 29, 100, 34}, 123);
        System.out.println(solution);
    }

    public static int solution(int[] numbers, int n) {
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (sum > n) {
                break;
            }
            sum += numbers[i];
        }

        return sum;
    }
}
