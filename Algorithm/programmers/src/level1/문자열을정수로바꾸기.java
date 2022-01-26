package level1;

public class 문자열을정수로바꾸기 {

    public static void main(String[] args) {
        solution("1234");
    }

    public static int solution(String s) {
        int answer = 0;

        if(s.startsWith("+")){
            // + 로 시작하면 양수로 변환
            int index = s.indexOf("+");
            String subString = s.substring(index);
            answer = Integer.parseInt(subString);
        } else if (s.startsWith("-")){
            // - 로 시작하면 음수로 변환
            answer = Integer.parseInt(s);
        } else {
            // 아니면 그냥 변환
            answer = Integer.parseInt(s);
        }

        return answer;
    }
}
