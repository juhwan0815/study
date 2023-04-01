package level0;

public class 배열원소의길이 {

    public static void main(String[] args) {
        solution(new String[]{"I", "Love", "Programmers."});
    }

    public static int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for (int i = 0; i < strlist.length; i++) {
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}
