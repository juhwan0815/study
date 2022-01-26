package level1;

public class 핸드폰번호가리기 {

    public static void main(String[] args) {
        solution("027774444");
    }

    public static String solution(String phone_number) {
        // 길이
        int length = phone_number.length();

        // 자르는 인덱스이자 첫단어의 길이
        int subIndex = length - 4;

        // 단어를 분리
        String firstWord = phone_number.substring(subIndex);
        String lastWord = phone_number.substring(subIndex, length);

        // 뒷자리 4개를 제외한 나머지 * 문자열을 생성
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < subIndex; i++) {
            stringBuilder.append("*");
        }
        stringBuilder.append(lastWord);
        return stringBuilder.toString();
    }
}
