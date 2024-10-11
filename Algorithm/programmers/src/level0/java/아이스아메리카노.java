package level0.java;

public class 아이스아메리카노 {

    public static void main(String[] args) {
        int[] solution = solution(15000);
        System.out.println(solution);
    }

    public static int[] solution(int money) {
        return new int[] {money / 5500, money % 5500};
    }
}
