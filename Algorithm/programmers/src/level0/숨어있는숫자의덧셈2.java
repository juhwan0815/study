package level0;

public class 숨어있는숫자의덧셈2 {

    public static void main(String[] args) {
        solution("aAb1B2cC34oOp");
    }

    public static int solution(String my_string) {
        int answer = 0;

        StringBuffer sb = new StringBuffer();

        char[] chars = my_string.toCharArray();

        char c = ' ';

        for(int i = 0; i < chars.length; i++) {

            if('0' <= chars[i] && chars[i] <= '9') {
                sb.append(chars[i]);
                c = chars[i];
            } else {
                if(c != ' '){
                    c = ' ';
                    sb.append(' ');
                }
            }
        }

        String numStr = sb.toString();
        if(numStr.length() > 0) {
            String[] numList = numStr.split(" ");

            for(String num : numList) {
                answer += Integer.parseInt(num);
            }
        }

        return answer;
    }


}
