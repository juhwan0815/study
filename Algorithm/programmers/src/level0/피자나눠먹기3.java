package level0;

public class 피자나눠먹기3 {

    public static void main(String[] args) {
        solution(4, 12);
    }

    public static int solution(int slice, int n) {
        int answer  = (n % slice) > 0 ? (n / slice) + 1 : (n / slice);
        return answer;
    }
}
