package level1;

public class 서울에서김서방찾기 {

    public static void main(String[] args) {
        solution(new String[]{"Jane", "Kim"});
    }

    public static String solution(String[] seoul) {
        String answer = null;

        // 배열의 요소가 Kim 인 요소를 찾는다.
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                answer = "김서방은 " + i+ "에 있다";
                break;
            }
        }

        return answer;
    }
}
