package level1;

public class 문자열내p와y의개수 {

    public static void main(String[] args) {
        solution("pPooyY");
    }

    public static boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        // 문자열을 문자 배열로 변환
        char[] charArray = s.toCharArray();

        // 문자를 돌면서 y 와 p 여부를 체크
        for (char c : charArray) {
            if ((c == 'y') || (c == 'Y')) {
                yCount++;
            } else if ((c == 'p') || (c == 'P')) {
                pCount++;
            }
        }

        return pCount == yCount;
    }
}
