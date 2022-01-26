package level1;

public class 제일작은수제거하기 {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 2, 1};
        int[] arr = {10};
        solution(arr);
    }

    public static int[] solution(int[] arr) {
        // 제일 작은수를 저장한다.
        int smallestNum = 0;

        // 제일 작은수를 찾아내는 반복문
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                smallestNum = arr[i];
                continue;
            }

            if (arr[i] < smallestNum) {
                smallestNum = arr[i];
            }
        }

        // 제일 작은 수를 제외한 배열을 만든다.
        int[] answer = new int[arr.length - 1];
        int currentNum = 0;
        for (int num : arr) {
            if (num != smallestNum) {
                answer[currentNum] = num;
                currentNum++;
            }
        }

        // 만약 결과 배열의 사이즈가 0이면 [-1] 반환
        if (answer.length == 0) {
            return new int[]{-1};
        }

        return answer;
    }
}
