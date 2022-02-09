package array;

import java.util.Scanner;

public class 보이는학생 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] numArray = new int[num];

        for (int i = 0; i < num; i++) {
            numArray[i] = scanner.nextInt();
        }

        System.out.println(solution(numArray));
    }

    public static int solution(int[] numArray) {
        int max = 0;
        int result = 0;

        for (int i = 0; i < numArray.length; i++) {
            if (numArray[i] > max) {
                result++;
                max = numArray[i];
            }
        }
        return result;
    }

}
