package level0;

public class 문자열뒤집기 {

    public static void main(String[] args) {
        solution("bread");
    }

    public static String solution(String my_string) {
        char[] chars = my_string.toCharArray();
        char[] result = new char[chars.length];

        int i = result.length - 1;
        for (char c : chars) {
            result[i] = c;
            i--;
        }
        return String.valueOf(result);
    }

}
