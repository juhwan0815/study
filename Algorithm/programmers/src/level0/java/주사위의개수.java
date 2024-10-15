package level0.java;

public class 주사위의개수 {

    public static void main(String[] args) {
        int solution = solution(new int[]{10, 8, 6}, 3);
        System.out.println(solution);
    }

    public static int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }
}
