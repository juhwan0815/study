package level0;

public class 암호해독 {

    public static void main(String[] args) {
        solution("dfjardstddetckdaccccdegk", 4);
    }

    public static String solution(String cipher, int code) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        char[] charArray = cipher.toCharArray();

        for(int i = code-1; i < charArray.length; i+= code) {
            sb.append(charArray[i]);
        }

        answer = sb.toString();

        return answer;
    }
}
