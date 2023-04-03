package level0;

public class 대문자와소문자 {

    public static void main(String[] args) {
        solution("abCdEfghIJ");
    }

    public static String solution(String my_string) {
        StringBuffer sb = new StringBuffer();

        char[] chars = my_string.toCharArray();

        for(char c : chars) {
            if('a' <= c && c <= 'z') {
                sb.append(String.valueOf(c).toUpperCase());
            } else if ('A' <= c && c <= 'Z') {
                sb.append(String.valueOf(c).toLowerCase());
            }
        }

        String answer = sb.toString();
        return answer;
    }

}
