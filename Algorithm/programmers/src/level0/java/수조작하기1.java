package level0.java;

public class 수조작하기1 {

    public static void main(String[] args) {
        int solution = solution(0, "wsdawsdassw");
        System.out.println(solution);
    }

    public static int solution(int n, String control) {
        char[] charArray = control.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'w') {
                n += 1;
            } else if (charArray[i] == 's') {
                n -= 1;
            } else if (charArray[i] == 'd') {
                n += 10;
            } else {
                n -= 10;
            }
        }

        return n;
    }
}
