package level0;

public class 개미군단 {

    public static void main(String[] args) {
        solution(23);
    }

    public static int solution(int hp) {
        int answer = 0;

        if((hp / 5) > 0) {
            answer += (hp / 5);
            hp -= 5 * (hp / 5);
        }

        if ((hp / 3) > 0) {
            answer += (hp / 3);
            hp -= 3 * (hp / 3);
        }

        answer += hp;
        return answer;
    }

}
