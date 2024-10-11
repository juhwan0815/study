package level0.java;

public class 옷가게할인받기 {

    public static void main(String[] args) {
        int solution = solution(153423);
        System.out.println(solution);
    }

    public static int solution(int price) {
        if (100000 <= price && price < 300000) {
            return price * 95 / 100;
        } else if (300000 <= price && price < 500000) {
            return price * 90 / 100;
        } else if (500000 <= price) {
            return price * 80 / 100;
        }
        return price;
    }
}
