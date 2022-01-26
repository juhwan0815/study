package level1;

public class 최대공약수와최소공배수 {

    public static void main(String[] args) {
        solution(2, 5);
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        // 큰수 작은수를 골라낸다.
        int biggerNum = 0;
        int smallNum = 0;

        if (n > m) {
            biggerNum = n;
            smallNum = m;

        } else {
            biggerNum = m;
            smallNum = n;
        }

        // 큰수부터 +1 반복문을 돌린다.
        // 최소 공배수는 큰수와 같거나 크다.
        // 최소공배수는 n,m 으로 나누었을 때 나머지가 0인 수
        for (int i = biggerNum; i >= biggerNum; i++) {
            if ((i % n) == 0 && (i % m) == 0) {
                answer[1] = i;
                break;
            }
        }

        // 최대공약수는 1부터 +1 반복문을 돌린다. 최대 공약수는 작은수보다 같거나 크다.
        // 최대공약수는 n,m 을 나누었을 때 나머지가 0인 수
        for (int i = 1; i <= smallNum; i++) {
            if ((n % i) == 0 && (m % i) == 0) {
                answer[0] = i;
            }
        }

        return answer;
    }
}
