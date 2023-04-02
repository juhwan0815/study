package level0;

public class 머쓱이보다키큰사람 {

    public static void main(String[] args) {
        solution(new int[]{180, 120, 140},190);
    }

    public static int solution(int[] array, int height) {
        int answer = 0;
        for (int friendHeight : array) {
            if(friendHeight > height) {
                answer++;
            }
        }
        return answer;
    }

}
