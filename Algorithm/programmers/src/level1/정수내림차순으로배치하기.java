package level1;

public class 정수내림차순으로배치하기 {

    public static void main(String[] args) {
        solution(118372);
    }

    public static long solution(long n) {
        // 정수를 문자열로 변환
        String strNum = String.valueOf(n);

        // 문자열을 문자 배열로 변환
        char[] charArray = strNum.toCharArray();

        // 문자를 정수로 바꿔서 배열에 저장
        int[] numArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            numArray[i] = Integer.parseInt(String.valueOf(charArray[i]));
        }

        // 높은 순으로 정렬
        for (int i = 0; i < numArray.length; i++) {
            for (int j = i + 1; j < numArray.length; j++) {
                if(numArray[i] < numArray[j]){
                    int temp = numArray[j];
                    numArray[j] = numArray[i];
                    numArray[i] = temp;
                }
            }
        }

        // 정수 배열를 문자열로 바꿔서 저장
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : numArray) {
            stringBuilder.append(num);
        }

        return Long.valueOf(stringBuilder.toString());
    }
}
