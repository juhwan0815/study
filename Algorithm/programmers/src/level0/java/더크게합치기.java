package level0.java;

public class 더크게합치기 {

    public static void main(String[] args) {
        int solution = solution(9, 91);
        System.out.println(solution);
    }

    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt(String.valueOf(a).concat(String.valueOf(b))),
                Integer.parseInt(String.valueOf(b).concat(String.valueOf(a))));
    }
}
