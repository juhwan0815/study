package level1;

public class 시저암호 {

    public static void main(String[] args) {
        solution("v w x y z", 4);
    }

    public static String solution(String s, int n) {
        // 문자열을 문자 배열로 변경
        char[] charArray = s.toCharArray();

        // 문자 배열을 돌면서
        for (int i = 0; i < s.length(); i++) {
            // 문자를 +1 증가시킨다.
            for (int j = 0; j < n; j++) {
                int ascii = 0;

                if (charArray[i] == 'z') {
                    // 만약 z -> a
                    charArray[i] = 'a';
                    continue;
                } else if (charArray[i] == 'Z') {
                    // 만약 Z -> A
                    charArray[i] = 'A';
                    continue;
                } else if (charArray[i] == ' ') {
                    // ' ' -> ' '
                    continue;
                } else {
                    // 이외일 경우 +1 해준다.
                    ascii = (byte) charArray[i] + 1;
                    charArray[i] = (char) ascii;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charArray);
        return stringBuilder.toString();
    }
}
