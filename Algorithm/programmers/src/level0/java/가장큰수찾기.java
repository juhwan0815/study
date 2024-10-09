package level0.java;

public class 가장큰수찾기 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{1, 8, 3});
        System.out.println(solution);
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[]{0, 0};

        for (int i = 0; i < array.length; i++) {
            if (answer[0] < array[i]) {
                answer[0] = array[i];
                answer[1] = i;
            }
        }
        return answer;
    }
}
