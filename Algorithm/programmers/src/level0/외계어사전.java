package level0;

public class 외계어사전 {

    public static void main(String[] args) {
        solution(new String[]{"p", "o", "s"}, new String[] {"sod", "eocd", "qixm", "adio", "soo"});
    }

    public static int solution(String[] spell, String[] dic) {
        int answer = 2;

        for(String s : dic) {

            int size = 0;

            for(String sp : spell) {
                if(!s.contains(sp)) {
                    break;
                }
                size++;
            }

            if(size == spell.length) {
                answer = 1;
                break;
            }
        }

        return answer;
    }

}
