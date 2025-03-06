package array;

public class EnhanceFor1 {

    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5};

        // 일반 for 문
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            System.out.println(number);
        }

        // 향상된 for 문, for-each 문
        for (int number : numbers) {
            System.out.println(number);
        }

        // for-each 문을 사용할 수 없는 경우, 증가하는 index 값 필요
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("number" + i + "번의 결과는: " + numbers[i]);
        }


    }
}
