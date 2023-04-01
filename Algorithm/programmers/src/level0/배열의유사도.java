package level0;

public class 배열의유사도 {

    public static void main(String[] args) {
        solution(new String[]{"a", "b", "c"}, new String[]{"com", "b", "d", "p", "c"});
    }

    public static int solution(String[] s1, String[] s2) {
        int answer = 0;
        for (String str1 : s1) {
            for (String str2 : s2) {
                if (str1.equals(str2)) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
