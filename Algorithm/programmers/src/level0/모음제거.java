package level0;

public class 모음제거 {

    public static void main(String[] args) {
        solution("nice to meet you");
    }

    public static String solution(String my_string) {
        StringBuffer sb = new StringBuffer();

        char[] chars = my_string.toCharArray();
        char[] filters = new char[] {'a', 'e', 'i', 'o', 'u'};

        for(char c : chars) {
            boolean exist = false;

            for(char f : filters) {
                if(c == f) {
                    exist = true;
                    break;
                }
            }

            if(exist == false) {
                sb.append(c);
            }
        }


        String answer = sb.toString();
        return answer;
    }
}
