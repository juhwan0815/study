package level0;

public class 배열두배만들기 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 100, -99, 1, 2, 3});
    }

    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++) {
            answer[i] = numbers[i] * 2;
        }

        return answer;
    }

}
