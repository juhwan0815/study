package level0;

public class 특정문자제거하기 {

    public static void main(String[] args) {
        solution("abcdef", "f");
    }

    public static String solution(String my_string, String letter) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        char[] charArray = my_string.toCharArray();
        char[] letterChar = letter.toCharArray();

        for(char c : charArray) {
            if(c != letterChar[0]) {
                sb.append(c);
            }
        }

        answer = sb.toString();
        return answer;
    }
}
