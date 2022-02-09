package array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 큰수출력하기 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] numArray = new int[num];
        for (int i = 0; i < num; i++) {
            numArray[i] = scanner.nextInt();
        }

        for (int n : solution(numArray)) {
            System.out.print(n + " ");
        }
    }

    public static int[] solution(int[] numArray) {
        List<Integer> numList = new ArrayList<>();
        numList.add(numArray[0]);

        for (int i = 1; i < numArray.length; i++) {
            if (numArray[i] > numArray[i - 1]) {
                numList.add(numArray[i]);
            }
        }

        int[] result = new int[numList.size()];
        for (int i = 0; i < numList.size(); i++) {
            result[i] = numList.get(i);
        }

        return result;
    }
}
