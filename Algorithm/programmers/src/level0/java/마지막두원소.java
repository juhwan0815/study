package level0.java;

import java.util.Arrays;

public class 마지막두원소 {

    public static void main(String[] args) {
        int[] solution = solution(new int[]{2, 1, 6});
        System.out.println(solution);
    }

    public static int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
        answer[answer.length -1] = num_list[num_list.length - 1] > num_list[num_list.length - 2]
                ? num_list[num_list.length - 1] - num_list[num_list.length - 2]
                : num_list[num_list.length - 1] * 2;
        return answer;
    }
}
