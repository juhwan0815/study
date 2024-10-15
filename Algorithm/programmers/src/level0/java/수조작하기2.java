package level0.java;

public class 수조작하기2 {

    public static void main(String[] args) {
        String solution = solution(new int[]{0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1});
        System.out.println(solution);
    }

    public static String solution(int[] numLog) {
        char[] chars = new char[numLog.length - 1];

        for (int i = 0; i < numLog.length - 1; i++) {
            int n = numLog[i + 1] - numLog[i];
            if (n == 1) {
                chars[i] = 'w';
            } else if (n == -1) {
                chars[i] = 's';
            } else if (n == 10) {
                chars[i] = 'd';
            } else {
                chars[i] = 'a';
            }
        }

        return String.valueOf(chars);
    }
}
