package level1;

public class 두정수사이의합 {

    public static void main(String[] args) {
        solution(5,3);
    }

    public static long solution(int a, int b) {
        long sum = 0;
        long biggerNum = 0;
        int smallerNum = 0;

        // 두 수를 비교
        if(a > b){
            biggerNum = a;
            smallerNum = b;
        } else {
            biggerNum = b;
            smallerNum = a;
        }

        // 작은 수부터 큰 수 까지 더한다.
        for(long i = smallerNum; i <= biggerNum ; i++){
            sum += i;
        }
        return sum;
    }
}
