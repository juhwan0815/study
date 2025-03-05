package casting;

public class Casting1 {

    public static void main(String[] args) {
        int intValue = 10;
        int longValue;
        double doubleValue;

        longValue = intValue; // int -> value
        System.out.println("longValue = " + longValue);

        doubleValue = intValue; // int -> double
        System.out.println("doubleValue = " + doubleValue);

        doubleValue = 20L; // long -> double
        System.out.println("doubleValue2 = " + doubleValue);
    }
}
