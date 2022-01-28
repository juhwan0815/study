package level1;

public class 숫자문자열과영단어 {

    public static void main(String[] args) {
        solution("23four5six7");
    }

    public static int solution(String s) {
        // 영어 배열
        String[] englishWords = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        // 반환용
        StringBuilder stringBuilder = new StringBuilder();

        // 문자열을 문자 배열로 변환
        char[] charArray = s.toCharArray();

        // 문자 배열을 돌면서
        for (int i = 0; i < charArray.length; i++) {

            if ((int) charArray[i] > 47 && (int) charArray[i] < 58) {
                // 숫자면 추가
                stringBuilder.append(charArray[i]);
            } else {
                // 숫자가 아닐 경우 3~5 길이의 문자를 더해서 영어 배열에 일치하는 것이 있는지 확인한다.
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < i + 5; j++) {
                    // 길이를 넘어가면 멈춘다.
                    if (j >= charArray.length) {
                        break;
                    }

                    // 3~5길이의 문자를 만들어서
                    sb.append(String.valueOf(charArray[j]));
                    if (sb.length() >= 3 && sb.length() <= 5) {
                        // 영어 배열에 일치하는 것이 있는지 확인하고 있으면 추가하고 i를 증가시킨다.
                        for (int k = 0; k < englishWords.length; k++) {
                            String word = sb.toString();
                            if (word.equals(englishWords[k])) {
                                stringBuilder.append(String.valueOf(k));
                                i += sb.length() - 1;
                                break;
                            }
                        }
                    }
                }
            }
        }


        return Integer.parseInt(stringBuilder.toString());
    }
}
