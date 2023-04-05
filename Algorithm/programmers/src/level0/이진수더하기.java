package level0;

public class 이진수더하기 {

    public static void main(String[] args) {
        solution("10", "11");
    }

    public static String solution(String bin1, String bin2) {
        String answer = "";

        int n1 = Integer.parseInt(bin1, 2);
        int n2 = Integer.parseInt(bin2, 2);

        answer = Integer.toBinaryString(n1 + n2);
        return answer;
    }

}
