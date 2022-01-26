package level1;

public class x만큼간격이있는n개의숫자 {

    public static void main(String[] args) {
        solution(-4, 2);
    }

    public static long[] solution(int x, int n) {
        // 숫자가 커서 long 타입으로 해야한다.
        long[] answer = new long[n];

        // 곱할때 숫자가 크면 long 사용
        for (long i = 1; i <= n; i++) {
            answer[(int) (i - 1)] = x * i;
        }
        return answer;
    }
}
