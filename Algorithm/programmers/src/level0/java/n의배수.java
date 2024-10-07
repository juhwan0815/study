package level0.java;

public class n의배수 {

    public static void main(String[] args) {
        int solution = solution(98, 2);
        System.out.println(solution);
    }

    public static int solution(int num, int n) {
        return (num % n) == 0 ? 1 : 0;
    }
}
