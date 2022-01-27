package level1;

import java.util.ArrayList;
import java.util.List;

public class 다트게임 {

    public static void main(String[] args) {
        solution("1D2S#10S");
    }

    public static int solution(String dartResult) {
        // 문자열을 문자배열로 만든다.
        char[] charArray = dartResult.toCharArray();

        // 정수를 저장하는 리스트
        List<Integer> numList = new ArrayList<>();
        int skipIndex = 0;
        int currentIndex = -1;

        // 문자배열을 돌면서
        for (int i = 0; i < charArray.length; i++) {

            // 10인경우는 스킵을 한번한다.
            if (skipIndex != 0 && i == skipIndex) {
                continue;
            }

            // 1일 경우 뒤에 문자가 0이 있는지 -> 10인지 확인하고
            if (charArray[i] == '1' && charArray[i + 1] == '0') {
                numList.add(10);
                currentIndex++;
                skipIndex = i + 1;
            } else if ((int) charArray[i] > 47 && (int) charArray[i] < 58) {
                // 정수면 리스트에 추가
                int num = Integer.parseInt(String.valueOf(charArray[i]));
                numList.add(num);
                currentIndex++;
                continue;
            } else if (charArray[i] == 'S') {
                // S 면 현재 정수를 1제곱
                Integer num = numList.remove(currentIndex);
                numList.add(currentIndex, (int) Math.pow(num.intValue(), 1));
            } else if (charArray[i] == 'D') {
                // D 면 현재 정수를 2제곱
                Integer num = numList.remove(currentIndex);
                numList.add(currentIndex, (int) Math.pow(num.intValue(), 2));
            } else if (charArray[i] == 'T') {
                // T 면 현재 정수를 3제곱
                Integer num = numList.remove(currentIndex);
                numList.add(currentIndex, (int) Math.pow(num.intValue(), 3));
            } else if (charArray[i] == '*') {
                // * 면 현재와 그전 정수를 *2
                Integer num = numList.remove(currentIndex);
                numList.add(currentIndex, num * 2);

                if (currentIndex > 0) {
                    Integer frontNum = numList.remove(currentIndex - 1);
                    numList.add(currentIndex - 1, frontNum * 2);
                }
            } else if (charArray[i] == '#') {
                // # 면 현재 정수를 * -1
                Integer num = numList.remove(currentIndex);
                numList.add(currentIndex, num * -1);
            }
        }

        // 정수를 다 더한다.
        int sum = 0;
        for (Integer num : numList) {
            sum += num;
        }

        return sum;
    }
}
