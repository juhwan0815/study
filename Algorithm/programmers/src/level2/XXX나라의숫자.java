package level2;

public class XXX나라의숫자 {

    public static void main(String[] args) {
        solution(19);
    }

    public static String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();

        // 10진법 -> 1 2 4 로 바꿔야함
        // 19 - 6/1 - 2/0  1/4/1
        while (n>0) {
            int remainder = n % 3;
            n = n / 3;

            if (remainder == 0) {
                n -= 1;
                stringBuilder.append("4");
            }

            if (remainder == 1) {
                stringBuilder.append("1");
            }

            if (remainder == 2) {
                stringBuilder.append("2");
            }
        }

        return stringBuilder.reverse().toString();

    }
}
