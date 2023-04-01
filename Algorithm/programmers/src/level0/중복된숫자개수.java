package level0;

public class 중복된숫자개수 {

    public static void main(String[] args) {
        solution(new int[]{1, 1, 2, 3, 4, 5}, 1);
    }

    public static int solution(int[] array, int n) {
        int answer = 0;
        for (int i : array) {
            if(i == n) {
                answer++;
            }
        }
        return answer;
    }

}
