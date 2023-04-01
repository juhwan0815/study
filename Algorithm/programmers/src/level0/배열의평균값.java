package level0;

public class 배열의평균값 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    }

    public static double solution(int[] numbers) {
        double answer = 0;

        for (int number : numbers) {
            answer += number;
        }
        ;
        return answer / numbers.length;
    }

}
