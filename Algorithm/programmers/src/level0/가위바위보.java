package level0;

public class 가위바위보 {

    public static void main(String[] args) {
        solution("205");
    }

    public static String solution(String rsp) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        char[] charArray = rsp.toCharArray();
        for(char c : charArray) {
            if(c == '2') {
                sb.append('0');
            } else if(c == '0') {
                sb.append('5');
            } else if(c == '5') {
                sb.append('2');
            }
        }

        answer = sb.toString();
        return answer;
    }
}
