package level0;

public class 컨트롤제트 {

    public static void main(String[] args) {
        solution("");
    }

    public static int solution(String s) {
        int answer = 0;

        String[] strArray = s.split(" ");

        int temp = 0;

        for(String str : strArray) {

            if("Z".equals(str)) {
                answer = answer - temp;
            } else {
                temp = Integer.parseInt(str);
                answer += temp;
            }
        }

        return answer;
    }

}
