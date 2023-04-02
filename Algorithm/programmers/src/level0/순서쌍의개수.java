package level0;

public class 순서쌍의개수 {

    public static void main(String[] args) {
        solution(100);
    }

    public static int solution(int n) {
        int answer = 0;

       for(int i = 1; i <= n; i++) {
           if((n % i) == 0){
               answer++;
           }
       }

        return answer;
    }

}
