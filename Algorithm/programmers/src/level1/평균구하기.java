package level1;

public class 평균구하기 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        double solution = solution(arr);
    }

    public static double solution(int[] arr) {
        // 배열안의 요소를 더한다.
        long sum = 0;
        for (int i : arr) {
            sum += i;
        }

        // 평균을 구한다.
        double average = (double) sum / arr.length;
        return average;
    }
}
