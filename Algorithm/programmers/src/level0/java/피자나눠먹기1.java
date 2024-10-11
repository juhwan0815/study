
package level0.java;

public class 피자나눠먹기1 {

    public static void main(String[] args) {
        int solution = solution(15);
        System.out.println(solution);
    }

    public static int solution(int n) {
        return (n % 7) == 0 ? (n / 7) : (n / 7) + 1;
    }
}
