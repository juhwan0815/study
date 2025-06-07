package method;

public class MethodCasting {

    public static void main(String[] args) {
        double number = 1.5;
//        printNumber(number); // double을 int에 대입하므로 컴파일 오류
        printNumber((int) number); // 명시적 형변환을 사용해 double을 int로 변환
    }

    public static void printNumber(int n) {
        System.out.println("숫자: " + n);
    }

}
