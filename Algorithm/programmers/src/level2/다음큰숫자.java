package level2;

public class 다음큰숫자 {

    public static void main(String[] args) {
        solution(78);
        solution(15);
    }

    public static int solution(int n) {


        int binaryCount = binaryCount(n);

        while (true) {
            int binaryCount1 = binaryCount(++n);

            if (binaryCount == binaryCount1) {
                break;
            }

        }

        return n;
    }

    public static int binaryCount(int n) {
        int count = 0;

        String str = Integer.toBinaryString(n);
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            if (c == '1') {
                count++;
            }
        }

        return count;
    }
}

