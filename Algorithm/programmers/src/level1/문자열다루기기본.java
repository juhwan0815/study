package level1;

public class 문자열다루기기본 {

    public static void main(String[] args) {
        solution("a1234");
    }

    public static boolean solution(String s) {
        boolean answer = true;

        // 문자열 길이가 4 or 6 인지 확인
        if(s.length() == 4 || s.length() == 6){
            // 문자열을 문자 배열로 변환
            char[] charArray = s.toCharArray();

            // 문자배열을 돌면서 ASCII 코드값으로 57 이상이면 문자라고 판별
            for (char c : charArray) {
                if ((byte) c > 57) {
                    answer = false;
                    break;
                }
            }
        } else {
            answer = false;
        }

        return answer;
    }
}
