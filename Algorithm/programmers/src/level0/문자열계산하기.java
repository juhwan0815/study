package level0;

public class 문자열계산하기 {

    public static void main(String[] args) {
        solution("3 + 4");
    }

    public static int solution(String my_string) {
        String[] strArray = my_string.split(" ");

        int answer = Integer.parseInt(strArray[0]);

        String temp = null;

        for(int i = 1; i < strArray.length; i++) {

            if(strArray[i].equals("+") || strArray[i].equals("-")) {
                temp = strArray[i];
            } else {
                if(temp.equals("+")) {
                    answer += Integer.parseInt(strArray[i]);
                } else {
                    answer -= Integer.parseInt(strArray[i]);
                }
            }
        }

        return answer;
    }
}
