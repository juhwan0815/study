package level0;

public class 합성수찾기 {

    public static void main(String[] args) {
        solution(15);
    }

    public static int solution(int n) {

        int answer = 0;

        for(int i = 1; i <= n; i++) {
            int count = 0;


            for(int j = 1; j <= n; j++) {
                if((i % j) == 0) {
                    count++;

                    if(count == 3) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }

}
