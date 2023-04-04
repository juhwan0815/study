package level0;

public class 숫자찾기 {

    public static void main(String[] args) {
        solution(232443, 4);
    }

    public static int solution(int num, int k) {
        int answer = -1;

        String numStr = String.valueOf(num);
        char[] chars = numStr.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            int n = Integer.parseInt(String.valueOf(chars[i]));

            if(n == k) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

}
