package level0;

public class 의개수7 {

    public static void main(String[] args) {
        solution(new int[] {7, 77, 14});
    }

    public static int solution(int[] array) {
        int answer = 0;

        for(int i : array) {
            String s = String.valueOf(i);

            char[] chars = s.toCharArray();

            for(char c : chars) {
                if(c == '7') {
                    answer++;
                }
            }
        }

        return answer;
    }

}
