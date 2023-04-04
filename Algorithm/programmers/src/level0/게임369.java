package level0;

public class 게임369 {

    public static void main(String[] args) {
        solution(29423);
    }

    public static int solution(int order) {
        int answer = 0;

        String numStr = String.valueOf(order);

        char[] chars = numStr.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            Integer num = Integer.parseInt(String.valueOf(chars[i]));

            if(num != 0 && (num % 3) == 0) {
                answer++;
            }
        }

        return answer;
    }

}
