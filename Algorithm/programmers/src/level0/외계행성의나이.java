package level0;

public class 외계행성의나이 {

    public static void main(String[] args) {
        solution(100);
    }

    public static String solution(int age) {
        String answer = "";

        StringBuffer sb = new StringBuffer();

        String ageStr = String.valueOf(age);

        char[] chars = ageStr.toCharArray();

        for(char c : chars) {
            int n = Integer.parseInt(String.valueOf(c));

            char a = 'a';

            for(int i = 0; i < n; i++) {
                a++;
            }

            sb.append(a);
        }

        answer = sb.toString();

        return answer;
    }
}
