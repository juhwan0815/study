package level1;

public class 문자열내림차순으로배치하기 {

    public static void main(String[] args) {
        solution("Zbcdefg");
    }

    public static String solution(String s) {
        char[] charArray = s.toCharArray();
        int[] numArray = new int[charArray.length];

        // 문자를 숫자로 저장
        for (int i = 0; i < charArray.length; i++) {
            numArray[i] = charArray[i];
        }

        // 숫자를 정렬
        for (int i = 0; i < numArray.length; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                if (numArray[i] < numArray[j]) {
                    int temp = numArray[i];
                    numArray[i] = numArray[j];
                    numArray[j] = temp;
                }
            }
        }

        // 숫자를 문자로 다시 변환하여 문자열로 만든다.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numArray.length; i++) {
            stringBuilder.append((char) numArray[i]);
        }

        return stringBuilder.toString();
    }
}
