package level0;

public class 옷가게할인받기 {

    public static void main(String[] args) {
        solution(580000);
    }

    public static int solution(int price) {
        int answer = 0;

        double discount = 0;

        if(100000 <= price && price < 300000) {
            discount = price * 0.05;
        } else if (300000 <= price && price < 500000) {
            discount = price * 0.1;
        } else if (500000 <= price) {
            discount = price * 0.2;
        }

        answer = (int) (price - discount);
        return answer;
    }

}
