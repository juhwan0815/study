package level1;

public class 수박수박수박수박수박수 {

    public static void main(String[] args) {
        solution(4);
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if ((i % 2) == 0) {
                // 짝수면 수
                stringBuilder.append("수");
            } else {
                // 홀수면 박
                stringBuilder.append("박");
            }
        }

        return stringBuilder.toString();
    }
}
