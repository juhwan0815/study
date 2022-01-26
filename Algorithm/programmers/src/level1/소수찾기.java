package level1;

public class 소수찾기 {

    public static void main(String[] args) {
        solution(5);
    }

    public static int solution(int n) {
        int count = 0;

        int[] numArray = new int[n+1];
        for (int i = 2; i <= n; i++) {
            numArray[i] = i;
        }

        // 1은 소수가 아니기 때문에 2부터 시작
        for (int i = 2; i <= n; i++) {
            // 이미 지워진 숫자면 패스
            if (numArray[i] == 0) {
                continue;
            }

            //  지워진 숫자가 아니라면 그 숫자의 배수를 다 지워버린다.
            for (int j = 2 * i; j <= n; j += i) {
                numArray[j] = 0;
            }
        }

        // 지워지지 않은 수 = 소수를 찾아낸다.
        for (int num : numArray) {
            if (num != 0) {
                count++;
            }
        }

        return count;
    }
}
