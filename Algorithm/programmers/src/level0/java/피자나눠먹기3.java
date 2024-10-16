package level0.java;

public class 피자나눠먹기3 {

    public static void main(String[] args) {
        int solution = solution(7, 10);
        System.out.println(solution);
    }

    public static int solution(int slice, int n) {
        return n / slice + (n % slice != 0 ? 1 : 0);
    }
}
