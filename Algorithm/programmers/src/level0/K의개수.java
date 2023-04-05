package level0;

public class K의개수 {

    public static void main(String[] args) {
        solution(1, 13, 1);
    }

    public static int solution(int i, int j, int k) {
        int answer = 0;

        for(int n = i ; n <= j; n++) {

            String numStr = String.valueOf(n);
            char[] chars = numStr.toCharArray();

            for(char c : chars) {
                int num = Integer.parseInt(String.valueOf(c));
                if(num == k) {
                    answer++;
                }
            }
        }

        return answer;
    }

}
