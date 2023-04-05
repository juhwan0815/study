package level0;

public class 모스부호1 {

    public static void main(String[] args) {
        solution("--. -.-- - .... --- -.");
    }

    public static String solution(String letter) {
        String[] strArray = new String[] {".-","-...","-.-.","-..",".","..-.","--.",
                "....","..",".---","-.-",".-..","--","-.",
                "---",".--.","--.-",".-.","...","-","..-",
                "...-",".--","-..-","-.--","--.."};

        String[] mosArray = letter.split(" ");

        StringBuffer sb = new StringBuffer();

        for(String mos : mosArray) {

            char c = 'a';

            for(String str : strArray) {
                if(mos.equals(str)) {
                    break;
                }
                c++;
            }

            sb.append(c);
        }

        String answer = sb.toString();
        return answer;
    }
}
