package level0.java;

public class 개미군단 {

    public static void main(String[] args) {
        int solution = solution(23);
        System.out.println(solution);
    }

    public static int solution(int hp) {
        int answer = 0;

        if (hp > 0) {
            answer += hp / 5;
            hp = hp % 5;
        }

        if (hp > 0) {
            answer += hp / 3;
            hp = hp % 3;
        }

        if (hp > 0) {
            answer += hp / 1;
        }

        return answer;
    }
}
