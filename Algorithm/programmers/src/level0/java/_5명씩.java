package level0.java;

public class _5명씩 {

    public static void main(String[] args) {
        String[] solution = solution(new String[]{
                "nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"
        });
        System.out.println(solution);
    }

    public static String[] solution(String[] names) {
        int n = names.length / 5;
        int m = names.length % 5 > 0 ? 1 : 0;
        n = n + m;

        String[] answer = new String[n];
        int offset = 0;
        for (int i = 0; i < names.length; i += 5) {
            answer[offset] = names[i];
            offset++;
        }
        return answer;
    }

}
