package level1;

public class 없는숫자더하기 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0});
    }

    public static int solution(int[] numbers) {
        int sum = 45;

        for (int i = 0; i < numbers.length; i++) {
            sum -= numbers[i];
        }

        return sum;
    }
}
